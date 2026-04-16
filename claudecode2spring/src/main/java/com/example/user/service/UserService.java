package com.example.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.user.dto.LoginDTO;
import com.example.user.dto.UserCreateDTO;
import com.example.user.dto.UserQueryDTO;
import com.example.user.dto.UserUpdateDTO;
import com.example.user.entity.User;

import java.util.Map;

public interface UserService extends IService<User> {

    Long createUser(UserCreateDTO dto);

    User getUserById(Long id);

    IPage<User> pageUsers(UserQueryDTO query);

    void updateUser(UserUpdateDTO dto);

    void deleteUser(Long id);

    Map<String, Object> login(LoginDTO dto);
}
