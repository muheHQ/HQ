package com.hong.backend.model.request;

import lombok.Data;

@Data
public class AdminRequest {

    private Integer id;
    private String username;
    private String password;
    private String confirmPassword;
}
