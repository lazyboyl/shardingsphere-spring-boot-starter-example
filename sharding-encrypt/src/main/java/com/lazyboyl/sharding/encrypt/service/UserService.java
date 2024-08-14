package com.lazyboyl.sharding.encrypt.service;


import com.lazyboyl.sharding.encrypt.dao.UserDao;
import com.lazyboyl.sharding.encrypt.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author linzf
 * @since 2021/11/16
 * 类描述：
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class UserService {

    @Resource
    private UserDao userDao;

    /**
     * 功能描述： 根据用户流水ID来删除用户
     *
     * @param userId
     */
    public void deleteUser(Long userId) {
        userDao.deleteByPrimaryKey(userId);
    }

    /**
     * 功能描述： 更新用户流水ID
     *
     * @param user 用户实体
     * @return 返回更新结果
     */
    public User updateUser(User user) {
        userDao.updateByPrimaryKey(user);
        return user;
    }


    /**
     * 功能描述： 根据用户名称和用户密码查询用户数据
     *
     * @param user 用户信息
     * @return 返回查询结果
     */
    public User queryUser(User user) {
        return userDao.queryUser(user);
    }

    /**
     * 功能描述： 实现新增用户
     *
     * @param user 用户实体
     * @return 返回新增的结果
     */
    public User saveUser(User user) {
        userDao.insertSelective(user);
        return user;
    }

}
