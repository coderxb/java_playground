package com.example.user.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.user.common.Result;
import com.example.user.dto.UserCreateDTO;
import com.example.user.dto.UserQueryDTO;
import com.example.user.dto.UserUpdateDTO;
import com.example.user.entity.User;
import com.example.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Api(tags = "用户管理")
public class UserController {

    private final UserService userService;

    @PostMapping
    @ApiOperation("新增用户")
    public Result<Long> create(@Validated @RequestBody UserCreateDTO dto) {
        Long id = userService.createUser(dto);
        return Result.success(id);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据ID查询用户")
    public Result<User> getById(@PathVariable Long id) {
        return Result.success(userService.getUserById(id));
    }

    @GetMapping
    @ApiOperation("分页查询用户列表")
    public Result<IPage<User>> list(UserQueryDTO query) {
        return Result.success(userService.pageUsers(query));
    }

    @PutMapping
    @ApiOperation("修改用户信息")
    public Result<Void> update(@Validated @RequestBody UserUpdateDTO dto) {
        userService.updateUser(dto);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除用户")
    public Result<Void> delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return Result.success();
    }
}
