package com.hong.backend.Constant;

/**
 * @Author HQ
 * @Date: 2024/6/2
 */
import com.hong.backend.Tools.JwtUtils;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mijiupro
 */


@RestController
@RequestMapping("/test")
@Tag(name = "JWT测试接口", description = "测试接口")
public class Test {
    private final JwtUtils jwtUtils;
    public Test(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @GetMapping("/get-token")
    public String getToken() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", "mijiu");
        claims.put("role", "admin");
        return jwtUtils.generateToken(claims,"user");
    }
    @GetMapping("/parse-token/{token}")
    public  String parseToken(@PathVariable String token) {
        return jwtUtils.parseToken(token).toString();

    }
}