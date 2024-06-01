package com.hong.backend.model.pojo;

import lombok.Data;

@Data
public class Register {
    private Integer id;
    private String username;
    private String password;
    private String confirmPassword;
}
