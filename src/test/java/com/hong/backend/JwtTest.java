//package com.hong.backend;
//
////import com.mijiu.commom.util.JwtUtils;
//import com.hong.backend.Tools.JwtUtils;
//import io.jsonwebtoken.Claims;
//import org.junit.jupiter.api.Test;
//
//import java.util.Map;
//
//public class JwtTest {
//
//    @Test
//    public void testJwt() {
//        // 设置JWT的payload
//        Map<String, Object> claims = Map.of("username", "hong", "role", "admin");
//
//        // 生成JWT
//        String jwt = JwtUtils.generateToken(claims, "secret");
//
//        System.out.println("JWT: " + jwt);
//
//        // 解析JWT
//        Claims claims1 = JwtUtils.parseToken(jwt);
//
//        // 获取完整的payload
//        String payload = claims1.toString();
//        System.out.println("Payload: " + payload);
//    }
//}