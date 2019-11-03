package com.zengjx.service;


import com.zengjx.domain.User;

public interface UserService {
    /***
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    public User findByUserId(Integer id);
}
