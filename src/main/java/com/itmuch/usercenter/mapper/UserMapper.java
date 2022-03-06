package com.itmuch.usercenter.mapper;

import com.itmuch.usercenter.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 分享 Mapper 接口
 * </p>
 *
 * @author hlc
 * @since 2022-03-06
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
