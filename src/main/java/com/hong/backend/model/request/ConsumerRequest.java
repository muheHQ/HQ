package com.hong.backend.model.request;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户请求体
 */
@Data
public class ConsumerRequest {
    private Integer id;
    private String username;

    /**
     * 密码
     */
    private String password;
    private String oldPassword;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 邮件
     */
    private String email;

    /**
     * 生日
     */
    private LocalDateTime brith;

    /**
     * 介绍
     */
    private String introduction;

    /**
     * 地点
     */
    private String location;

    /**
     * 头像
     */
    private String avator;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
