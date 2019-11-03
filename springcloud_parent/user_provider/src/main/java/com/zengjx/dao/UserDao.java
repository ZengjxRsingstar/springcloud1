package com.zengjx.dao;

import com.zengjx.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author zengjx
 * @Company zengjx
 * @Date 2019/11/3  20:06
 * @Version V1.0
 */
public interface UserDao  extends JpaRepository<User,Integer> {

}
