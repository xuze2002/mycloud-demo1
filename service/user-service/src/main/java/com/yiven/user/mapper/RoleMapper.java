package com.yiven.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yiven.model.user.entity.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
}
