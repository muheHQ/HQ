package com.hong.backend;

import com.hong.backend.Tools.JwtUtils;
import io.swagger.v3.oas.annotations.Operation;
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
@Tag(name = "JWT测试模块", description = "测试模块")
public class TestController {
    private final JwtUtils jwtUtils;
    public TestController(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Operation(summary = "生成JWT令牌")
    @GetMapping("/get-token")
    public String getToken() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", "hong");
        claims.put("role", "admin");
        return jwtUtils.generateToken(claims,"user");
    }

    @Operation(summary = "解析JWT令牌")
    @GetMapping("/parse-token/{token}")
    public  String parseToken(@PathVariable String token) {
        return jwtUtils.parseToken(token).toString();

    }
}
