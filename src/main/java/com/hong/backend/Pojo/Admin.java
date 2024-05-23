package com.hong.backend.Pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName(value = "admin")
@Data
public class Admin {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String password;
}
