package com.hong.backend.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/user")
@Tag(name = "用户模块", description = "用户模块")
public class userController {
    @GetMapping("/hong")
    @Operation(summary = "用户信息测试")
    public void user(){
        System.out.println("hello");
    }
}
