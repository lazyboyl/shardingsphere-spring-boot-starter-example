package com.lazyboyl.sharding.encrypt.controller;


import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.lazyboyl.sharding.encrypt.entity.User;
import com.lazyboyl.sharding.encrypt.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author linzf
 * @since 2021/11/16
 * 类描述：
 */
@RestController
@Api(tags = UserController.TAG_NAME)
public class UserController {

    protected static final String TAG_NAME = "encrypt数据加密的相关接口";

    @Resource
    private UserService userService;


    /**
     * 功能描述： 根据用户名称查询用户数据
     *
     * @param userName
     * @return
     */
    @PostMapping("queryUserByUserName")
    @ApiOperation(value = "根据用户名称查询用户数据", tags = TAG_NAME)
    @ApiOperationSupport(order = 5)
    public User queryUserByUserName(String userName, Long userId) {
        return userService.queryUserByUserName(userName, userId);
    }

    /**
     * 功能描述： 根据用户流水ID来删除用户
     *
     * @param userId
     */
    @PostMapping("deleteUser")
    @ApiOperation(value = "删除用户", tags = TAG_NAME)
    @ApiOperationSupport(order = 4)
    public void deleteUser(Long userId) {
        userService.deleteUser(userId);
    }

    /**
     * 功能描述： 更新用户流水ID
     *
     * @param user 用户实体
     * @return 返回更新结果
     */
    @PostMapping("updateUser")
    @ApiOperation(value = "更新用户", tags = TAG_NAME)
    @ApiOperationSupport(order = 3)
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    /**
     * 功能描述： 根据用户名称和用户密码查询用户数据
     *
     * @param user 用户信息
     * @return 返回查询结果
     */
    @PostMapping("queryUser")
    @ApiOperation(value = "用户名称和用户密码查询用户数据", tags = TAG_NAME)
    @ApiOperationSupport(order = 2)
    public User queryUser(@RequestBody User user) {
        return userService.queryUser(user);
    }

    /**
     * 功能描述： 实现新增用户
     *
     * @param user 用户实体
     * @return 返回新增的结果
     */
    @PostMapping("saveUser")
    @ApiOperation(value = "新增用户", tags = TAG_NAME)
    @ApiOperationSupport(order = 1)
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
