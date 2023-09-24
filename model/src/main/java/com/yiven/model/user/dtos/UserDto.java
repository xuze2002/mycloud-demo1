package com.yiven.model.user.dtos;

import lombok.Data;

@Data
public class UserDto {

    private String username;

    private String password;

    private String role;  // 角色选择在DTO中

}
