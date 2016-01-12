package com.jlu.zhu.service.impl;


import com.alibaba.fastjson.JSON;
import com.jlu.zhu.AbstractComponentTest;
import com.jlu.zhu.entity.UserEntity;
import com.jlu.zhu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.List;

/**
 * UserServiceImplTest
 *
 * @author <a href="mailto:zz_xiaozhu@163.com">风袭</a>
 * @version V1.0.0
 * @since 2015-11-23
 */
public class UserServiceImplTest extends AbstractComponentTest {

    @Autowired
    private UserService userService;

    @Test
    public void GetUserByIdTest() {

        UserEntity user = userService.getUserById(1);
        System.out.println(JSON.toJSONString(user));
    }

    @Test
    public void GetUsersTest() {
        List<UserEntity> list = userService.getUsers();
        //new ArrayList<User>();

        for (UserEntity user : list) {
            System.out.println(JSON.toJSONString(user));
        }
    }

    @Test
    public void InsertUserTest() {

        UserEntity user = new UserEntity();
        user.setFirstname("ccc");
        user.setId(777);
        user.setLastname("zzz");
        user.setPassword("123");


        int insert_user = userService.insertUser(user);
        System.out.println(JSON.toJSONString(insert_user) + "success");

    }
}
