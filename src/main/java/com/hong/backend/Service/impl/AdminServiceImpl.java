package com.hong.backend.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hong.backend.Tools.Result;
import com.hong.backend.Model.pojo.Admin;
import com.hong.backend.Mapper.AdminMapper;
import com.hong.backend.Model.pojo.Register;
import com.hong.backend.Model.request.AdminRequest;
import com.hong.backend.Service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HQ
 * @since 2024-05-23
 */
@Service
@Slf4j
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Override
    public Result isLogin(AdminRequest adminRequest, HttpSession session) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", adminRequest.getUsername());
        queryWrapper.eq("password", adminRequest.getPassword());
        if(this.count(queryWrapper) > 0){
            session.setAttribute("name", adminRequest.getUsername());
            log.info("用户{}登录成功", adminRequest.getUsername());
            return Result.success("登录成功");
        } else {
            log.error("用户{}登录失败", adminRequest.getUsername());
            return Result.error("用户名或者密码错误");
        }
    }

    /**
     * 注册
     * @param register
     * @return
     */
    public Result register(Register register) {
        //Create a QueryWrapper object to query the database
       QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        //Set the username to the username in the Register object
        queryWrapper.eq("username", register.getUsername());
        //Query the database for an existing admin
        Admin existingAdmin = this.getOne(queryWrapper);
        //If an existing admin is found, return an error
        if(existingAdmin != null){
            return Result.error("用户名已存在");
        }
//Check if the password and confirm password are not equal
        if(!register.getPassword().equals(register.getConfirmPassword())){
//Return an error message if they are not equal
            return Result.error("两次密码不一致请重新输入");
        }
        Admin admin = new Admin();
//        DigestUtils.md5DigestAsHex()
        admin.setUsername(register.getUsername());
        admin.setPassword(register.getPassword());
        boolean save = this.save(admin);
        if(save){
            log.info("注册成功");
            return Result.success("注册成功");
        } else {
            log.info("注册失败");
            return Result.error("注册失败");
        }
    }
}
