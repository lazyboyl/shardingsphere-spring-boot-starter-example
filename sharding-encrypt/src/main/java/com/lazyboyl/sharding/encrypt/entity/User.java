package com.lazyboyl.sharding.encrypt.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author linzf
 * @since 2021/11/16
 * 类描述：
 */
@Table(name = "t_user")
public class User {

    /**
     * 用户流水ID
     */
    @Id
    @Column(name = "user_id")
    private Long userId;

    /**
     * 用户名称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户名称加密模糊匹配
     */
    @Column(name = "user_name_like_query")
    private String userNameLikeQuery;


    /**
     * 用户密码
     */
    @Column(name = "pwd")
    private String pwd;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUserNameLikeQuery() {
        return userNameLikeQuery;
    }

    public void setUserNameLikeQuery(String userNameLikeQuery) {
        this.userNameLikeQuery = userNameLikeQuery;
    }

}
