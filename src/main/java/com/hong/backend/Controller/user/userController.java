
package com.hong.backend.Controller.user;

import com.hong.backend.Pojo.User;
import com.hong.backend.Service.ServiceImpl.UserServiceImpl;
import com.hong.backend.Tools.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user")
@Tag(name = "用户模块", description = "用户模块")
public class userController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/hong")
    @Operation(summary = "用户信息测试")
    public Result<List<User>> user() {
        System.out.println("hello");
        List<User> users = userService.selectAll();
        System.out.println(users);
        return Result.success(users);
    }

}
