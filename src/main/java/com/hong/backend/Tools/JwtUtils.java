package com.hong.backend.Tools;


import io.jsonwebtoken.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


import java.util.Date;
import java.util.Map;


/**
 * @author mijiupro
 */
@Data
@Component
public class JwtUtils {
    private String secret = "123456";//密钥
//    private  long expiration = 10000;//过期时间
    private  long expiration = 43200000;//过期时间

    public static Boolean checkToken(String token) {
        System.out.println(token);
        if(token == null){
            return false;
        }

        try {
            Map<String, Object> claims = Jwts.parser()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            return false;
        }

        return true;
    }


    /**
     * 生成token令牌
     * @param claims JWT第二部分负载 payload 中存储的内容
     * @param subject 主题(用户类型)
     * @return token
     */
    public  String  generateToken(Map<String,Object> claims, String subject) {
        System.out.println("--------------");
        System.out.println(secret);
        System.out.println(expiration);
        return Jwts.builder()
                .setId(Claims.ID)//设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为令牌的唯一标识。
                .setSubject("hong")//设置主题,一般为用户类型
                .setIssuedAt(new Date())//设置签发时间
                .addClaims(claims)//设置负载
                .signWith(SignatureAlgorithm.HS256, secret)//设置签名算法
                .setExpiration(new Date(System.currentTimeMillis() + expiration))//设置令牌过期时间
                .compact();//生成令牌
    }

    /**
     * 解析token令牌
     * @param token token令牌
     * @return 负载
     */
    public  Claims parseToken(String token) {

        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     *  验证token令牌
     * @param token 令牌
     * @return 是否有效
     */
    public  boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 刷新Token
     * @param token 旧的Token令牌
     * @return 新的Token令牌
     */
    public  String refreshToken(String token) {
        try {
            // 解析旧的Token，获取负载信息
            Claims claims = parseToken(token);
            // 生成新的Token，设置过期时间和签名算法等参数
            return generateToken(claims, claims.getSubject());
        } catch (Exception e) {
            throw new RuntimeException("无法刷新令牌！", e);
        }
    }


    /**
     * 从令牌中获取主题信息
     * @param token 令牌
     * @return 主题信息(用户类型)
     */
    public  String getSubjectFromToken(String token) {
        try {
            Claims claims = parseToken(token); // 解析令牌，获取负载信息
            return claims.getSubject(); // 返回主题信息
        } catch (Exception e) {
            throw new RuntimeException("无法从令牌中获取主题。", e);
        }
    }
}