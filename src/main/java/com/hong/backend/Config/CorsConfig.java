package com.hong.backend.Config;

/**
 * @Author HQ
 * @Date: 2024/6/2
 * 配置跨域
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 配置跨域请求处理
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080", "http://localhost:8888") // 允许的来源
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 允许的请求方法
                .allowedHeaders("*") // 允许的请求头
                .maxAge(3600) // 预检请求的有效期，单位：秒
                .allowCredentials(true); // 是否支持用户凭证（例如：Cookies），默认为 false
    }
}