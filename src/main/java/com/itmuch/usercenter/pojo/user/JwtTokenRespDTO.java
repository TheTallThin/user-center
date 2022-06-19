package com.itmuch.usercenter.pojo.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;

/**
 * 登录响应
 * @author 何林冲
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class JwtTokenRespDTO {

    /**
     * token
     */
    private String token;

    /**
     * 过期时间
     */
    private Long expirationTime;
}
