package com.yiven.user.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yiven.model.common.dtos.ResponseResult;
import com.yiven.model.common.enums.AppHttpCodeEnum;
import com.yiven.model.user.dtos.UserDto;
import com.yiven.model.user.entity.Role;
import com.yiven.model.user.entity.Rs;
import com.yiven.model.user.entity.User;
import com.yiven.user.mapper.RsMapper;
import com.yiven.user.mapper.UserMapper;
import com.yiven.user.mapper.RoleMapper;
import com.yiven.user.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    /**
     * 登录
     * @param dto
     * @return
     */
    @Override
    public ResponseResult login(UserDto dto) {
        if (StringUtils.isNotBlank(dto.getUsername()) && StringUtils.isNotBlank(dto.getPassword())){
            User user = getOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, dto.getUsername()));

            if (user == null){
                return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST,"用户信息不存在");
            }
            String pswd = user.getPassword();
            if (!pswd.equals(dto.getPassword())){
                return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR);
            }
            String userRoles = userMapper.getUserRoles(user.getId());

            user.setRoles(userRoles);
            if (userRoles.equals(dto.getRole())){
                System.out.println("true");
                user.setPassword("");
                return ResponseResult.okResult(user);
            }

        }
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REQUIRE);

    }


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RsMapper rsMapper;

    /**
     * 注册
     * @param user
     * @return
     */
    @Override
    public ResponseResult register(User user) {
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword()) || StringUtils.isBlank(user.getPhone())){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REQUIRE);
        }

        User user1 = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername()));
        if (user1 == null){
            /*save(user);*/
            Integer saveEntityAndGetKey = saveEntityAndGetKey(user);
            Rs rs = new Rs();
            rs.setUid(saveEntityAndGetKey);
            rs.setRid(2);
            rsMapper.insert(rs);
        }
        return ResponseResult.errorResult(AppHttpCodeEnum.DATA_EXIST);
    }

    @Autowired
    private RoleMapper roleMapper;
    public List<Role> roles(){
        List<Role> roles = roleMapper.selectList(null);
        return roles;
    }

    public Integer saveEntityAndGetKey(User user){
        userMapper.insert(user);
        return user.getId();
    }
}
