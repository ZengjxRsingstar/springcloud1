package com.zengjx.controller;


import com.zengjx.domain.User;
import com.zengjx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Steven
 * @version 1.0
 * @description com.itheima.controller
 * @date 2019-11-3
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    //http://localhost:18081/user/1  -查询-get
    //http://localhost:18081/user  -新增-post
    //http://localhost:18081/user -修改-put
    //http://localhost:18081/user/1  -删除-delet
    @RequestMapping("{id}")
    public User findById(@PathVariable Integer id){
      User user=userService.findByUserId(id);
        user.setName(user.getUsername()+"生产者1");


        try {
            Thread.sleep(3000);
            System.out.println("休眠3秒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return user;
    }
}
