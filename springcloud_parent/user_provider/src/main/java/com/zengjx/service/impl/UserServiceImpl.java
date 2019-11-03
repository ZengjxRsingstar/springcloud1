package com.zengjx.service.impl;

import com.zengjx.dao.UserDao;
import com.zengjx.domain.User;
import com.zengjx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author zengjx
 * @Company zengjx
 * @Date 2019/11/3  19:34
 * @Version V1.0
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    @Override
    public User findByUserId(Integer id) {
        return userDao.findById(id).get();
    }

}
