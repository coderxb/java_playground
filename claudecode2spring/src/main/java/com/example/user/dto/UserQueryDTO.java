package com.example.user.dto;

import com.example.user.common.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("用户分页查询参数")
public class UserQueryDTO extends PageQuery {

    @ApiModelProperty("用户名（模糊查询）")
    private String username;

    @ApiModelProperty("邮箱（模糊查询）")
    private String email;

    @ApiModelProperty("手机号（模糊查询）")
    private String phone;
}
