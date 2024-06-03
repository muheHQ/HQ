package com.hong.backend.controller;

import com.hong.backend.Tools.JwtUtils;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author HQ
 * @Date: 2024/6/2
 */
@RestController
@Tag(name = "Token检查")
@Slf4j
//@CrossOrigin
public class checkTokenController {
    @Autowired
    private JwtUtils jwtUtils;
    @GetMapping("/checkToken")
    public Boolean checkToken(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("token");
        log.info("token:{}",token);
        Map<String, Object> claims = jwtUtils.parseToken(token);
        System.out.println(claims);
        if(claims == null){
            return false;
        } else {
            return true;
        }
//        return JwtUtils.checkToken(token);
    }
}
