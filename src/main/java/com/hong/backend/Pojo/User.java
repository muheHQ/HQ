package com.hong.backend.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private Integer age;
    private Integer gender;  // 0为女性 1为男性
    private String country;
}
