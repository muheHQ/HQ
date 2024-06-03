package com.hong.backend.Model.pojo;

import lombok.Data;

@Data
public class Register {
    private Integer id;
    private String username;
    private String password;
    private String confirmPassword;
}
