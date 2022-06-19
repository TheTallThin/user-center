package com.itmuch.usercenter.pojo.user;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 何林冲
 */
@ApiModel(value = "UserRespDTO",description = "用户响应DTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRespDTO {

    @ApiModelProperty(value = "Id")
    private Integer id;
    @ApiModelProperty(value = "头像地址")
    private String avatarUrl;
    @ApiModelProperty(value = "积分")
    private Integer bonus;
    @ApiModelProperty(value = "微信昵称")
    private String wxNickname;
}
