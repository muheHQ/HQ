package com.hong.backend.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hong.backend.Tools.JwtUtils;
import com.hong.backend.Tools.Result;
import com.hong.backend.Model.pojo.Consumer;
import com.hong.backend.Mapper.ConsumerMapper;
import com.hong.backend.Model.request.ConsumerRequest;
import com.hong.backend.Service.IConsumerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static com.hong.backend.Constant.Constants.MUHE;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author HQ
 * @since 2024-05-23
 */


@Service
public class ConsumerServiceImpl extends ServiceImpl<ConsumerMapper, Consumer> implements IConsumerService {
    @Autowired
    private ConsumerMapper consumerMapper;
    @Autowired
    private JwtUtils jwtUtils;

    /**
     * 新增用户和
     * @param registerConsumerRequest
     * @return
     */
    public Result addUser(ConsumerRequest registerConsumerRequest) {
        if (this.existUser(registerConsumerRequest.getUsername())) {
            return Result.error("当前用户已经存在");
        }

        Consumer consumer = new Consumer();
        BeanUtils.copyProperties(registerConsumerRequest, consumer);

        // MD5 加密一下
        String password = DigestUtils.md5DigestAsHex((MUHE + registerConsumerRequest.getPassword()).getBytes(StandardCharsets.UTF_8));
        consumer.setPassword(password);
        consumer.setAvator("img/avatorImages/user.png");

        try {
            if(consumerMapper.insert(consumer) > 0){
                Result.success("注册成功");
            } else {
                Result.error("注册失败");
            }
        } catch (Exception e) {
            return Result.fatal(e.getMessage());
        }
        return null;
    }

    /**
     * 登录
     * @param consumerRequest
     * @param session
     * @return
     */
    @Override
    public Result isLogin(ConsumerRequest consumerRequest, HttpSession session) {
        String username = consumerRequest.getUsername();
        String password = consumerRequest.getPassword();

        // 验证用户名和密码
        // 验证成功后，将用户信息存入session中
        if (this.verifyUser(username, password)) {

            // 添加负载内容到 claims 中 生成jwt令牌
            Map<String, Object> claims = new HashMap<>();
            claims.put("username", username);
            String token = jwtUtils.generateToken(claims, "user");

            session.setAttribute("username", username);

            // 返回登录成功及JWT令牌
            Map<String, Object> data = new HashMap<>();
            data.put("username", username);
            data.put("token", token);
            data.put("code", 200);
            return Result.success("登录成功", data);
        } else {
            return Result.error("用户名或密码错误");
        }
    }

    private boolean verifyUser(String username, String password) {
        QueryWrapper<Consumer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        String secretPassword = DigestUtils.md5DigestAsHex((MUHE + password).getBytes(StandardCharsets.UTF_8));
        queryWrapper.eq("password", secretPassword);
        return consumerMapper.selectCount(queryWrapper) >0;
    }


    private Boolean existUser(String username) {
        QueryWrapper<Consumer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return consumerMapper.selectCount(queryWrapper) > 0;

/*        Consumer consumer = consumerMapper.selectOne(queryWrapper);
        if (consumer != null) {
            return true;
        } else {
            return false;
        }*/

    }
}
