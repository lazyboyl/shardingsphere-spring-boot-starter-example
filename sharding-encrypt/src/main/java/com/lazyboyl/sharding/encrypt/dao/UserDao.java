package com.lazyboyl.sharding.encrypt.dao;

import com.lazyboyl.sharding.encrypt.entity.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author linzf
 * @since 2021/11/16
 * 类描述：
 */
public interface UserDao extends Mapper<User> {

    /**
     * 功能描述： 根据用户名称和用户密码查询用户数据
     *
     * @param user 用户信息
     * @return 返回查询结果
     */
    User queryUser(User user);

}
