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
@ApiModel(value = "用户登陆")
public class UserLoginDTO {

    @ApiModelProperty(value = "头像地址")

    private String avatarUrl;
    @ApiModelProperty(value = "code")

    private String code;
    @ApiModelProperty(value = "微信昵称")
    private String wxNickname;
}
