package com.hong.backend.Service.ServiceImpl;

import com.hong.backend.Mapper.UserMapper;
import com.hong.backend.Pojo.User;
import com.hong.backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper usrMapper;


    /**
     * 查询全部用户
     * @return
     */
    public List<User> selectAll() {

        return usrMapper.selectAll();
    }
}
