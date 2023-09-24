package com.yiven.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yiven.model.common.dtos.ResponseResult;
import com.yiven.model.user.dtos.UserDto;
import com.yiven.model.user.entity.Role;
import com.yiven.model.user.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface UserService extends IService<User> {
    /**
     * 登录
     * @param dto
     * @return
     */
    public ResponseResult login(UserDto dto);

    /**
     * 注册
     * @param user
     * @return
     */
    public ResponseResult register(User user);

    /**
     * 展示角色列表
     * @return
     */
    public List<Role> roles();
}
