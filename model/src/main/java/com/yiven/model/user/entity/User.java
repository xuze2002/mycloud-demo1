package com.yiven.model.user.entity;


import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
/**
* 
* @TableName user
*/
@Data
@TableName("user")
public class User implements Serializable {

    /**
    * 
    */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
    * 
    */
    @TableField("username")
    private String username;
    /**
    * 
    */
    @TableField("password")
    private String password;
    /**
    * 
    */
    @TableField("phone")
    private String phone;

    //当前用户具备哪些角色
    @TableField(exist = false)
    private String roles;



}
