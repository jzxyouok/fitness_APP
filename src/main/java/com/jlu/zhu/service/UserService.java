package com.jlu.zhu.service;

import com.jlu.zhu.entity.UserEntity;

import java.util.List;

/**
 * UserService
 *
 * @author <a href="mailto:zz_xiaozhu@163.com">风袭</a>
 * @version V1.0.0
 * @since 2015-11-23
 */
public interface UserService {

    UserEntity getUserById(Integer userId);

    List<UserEntity> getUsers();

    int insertUser(UserEntity user);

    int updateUser(UserEntity record);

    int deleteUser(Integer id);


}
