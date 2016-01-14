package com.jlu.zhu.service.impl;


import com.alibaba.fastjson.JSON;
import com.jlu.zhu.AbstractComponentTest;
import com.jlu.zhu.entity.UserEntity;
import com.jlu.zhu.service.UserService;
import com.jlu.zhu.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
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
    @Test
    public void testTime() throws Exception{
        long l =  System.currentTimeMillis();
        //1452737423613 代表(2016-01- 14 10:10:23)则
        System.out.println(l);
        //System.out.println(DateUtil.getDateString(DateUtil.getDate("1992-03-21")));



        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//        System.out.print(DateUtil.getHourBeginTime(l));
//        System.out.println(simpleDateFormat.format(DateUtil.getHourBeginTime(l)));
//        System.out.print(DateUtil.getHourEndTime(l));
//        System.out.println(simpleDateFormat.format(DateUtil.getHourEndTime(l)));
//        System.out.print(DateUtil.getDayBeginTime(l));
//        System.out.println(simpleDateFormat.format(DateUtil.getDayBeginTime(l)));
//        System.out.print(DateUtil.getDayEndTime(l));
//        System.out.println(simpleDateFormat.format(DateUtil.getDayEndTime(l)));
//        System.out.print(DateUtil.getMonthBeginTime(l));
//        System.out.println(simpleDateFormat.format(DateUtil.getMonthBeginTime(l)));
//        System.out.print(DateUtil.getMonthEndTime(l));
//        System.out.println(simpleDateFormat.format(DateUtil.getMonthEndTime(l)));
//        System.out.print(DateUtil.getYearBeginTime(l));
//        System.out.println(simpleDateFormat.format(DateUtil.getYearBeginTime(l)));
//        System.out.print(DateUtil.getYearEndTime(l));
//        System.out.println(simpleDateFormat.format(DateUtil.getYearEndTime(l)));
        String now = simpleDateFormat.format(l);
        System.out.println(now);
        System.out.println(simpleDateFormat.format(DateUtil.addMinute(l,10)));
        System.out.println(simpleDateFormat.format(DateUtil.addHour(l,2)));
        System.out.println(simpleDateFormat.format(DateUtil.addDay(l,2)));
        System.out.println(simpleDateFormat.format(DateUtil.addMonth(l,2)));
        System.out.println(simpleDateFormat.format(DateUtil.addYear(l,2)));

//        System.out.println(simpleDateFormat.parse(now).getTime());
//        1452595664860
//        2016-01-12 06:47:44


    }
}
