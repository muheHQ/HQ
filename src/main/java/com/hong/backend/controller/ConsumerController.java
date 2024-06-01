package com.hong.backend.controller;


import com.hong.backend.Tools.Result;
import com.hong.backend.model.request.AdminRequest;
import com.hong.backend.model.request.ConsumerRequest;
import com.hong.backend.service.IConsumerService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户Controller
 * @author HQ
 * @since 2024-05-23
 */
@RestController
@RequestMapping("/user")
@Slf4j
@CrossOrigin(origins = "http://localhost:8888", methods = {RequestMethod.POST}, allowedHeaders = {"Content-Type"})
public class ConsumerController {
    @Autowired
    private IConsumerService iConsumerService;

    /**
     * 用户注册
     * @param registerConsumerRequest
     * @return
     */
    @PostMapping("/register")
    public Result addUser(@RequestBody ConsumerRequest registerConsumerRequest){
        log.info("用户注册");
        return iConsumerService.addUser(registerConsumerRequest);
    }

    @PostMapping("/login/status")
    @Operation(summary = "登录接口", description = "用户登录接口")
    public Result login(@RequestBody ConsumerRequest consumerRequest, HttpSession session){
        return iConsumerService.isLogin(consumerRequest,session);
    }
}
