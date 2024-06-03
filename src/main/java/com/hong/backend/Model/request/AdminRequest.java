package com.hong.backend.Model.request;

import lombok.Data;

@Data
public class AdminRequest {

    private Integer id;
    private String username;
    private String password;
    private String confirmPassword;
}
