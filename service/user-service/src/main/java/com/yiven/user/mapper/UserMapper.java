package com.yiven.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yiven.model.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    String getUserRoles(Integer userId);
}
