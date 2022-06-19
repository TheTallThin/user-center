package com.itmuch.usercenter.pojo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 何林冲
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@ApiModel(description = "登录响应DTO",value = "LoginRespDTO对象")
public class LoginRespDTO {

    @ApiModelProperty(value = "JwtTokenRespDTO 对象")
    private JwtTokenRespDTO token;
    @ApiModelProperty(value = "user用户对象")
    private UserRespDTO user;
}
