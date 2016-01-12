package com.jlu.zhu.service.impl;

import com.jlu.zhu.dao.UserEntityMapper;
import com.jlu.zhu.entity.UserEntity;
import com.jlu.zhu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserServiceImpl
 *
 * @author <a href="mailto:zz_xiaozhu@163.com">风袭</a>
 * @version V1.0.0
 * @since 2015-11-23
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserEntityMapper userEntityMapper;


    public UserEntity getUserById(Integer userId) {
        return userEntityMapper.selectByPrimaryKey(userId);
    }

    public List<UserEntity> getUsers() {
        return userEntityMapper.getUsers();
    }

    public int insertUser(UserEntity user) {
        return userEntityMapper.insertSelective(user);
    }

    public int updateUser(UserEntity record) {
        return userEntityMapper.updateByPrimaryKey(record);
    }

    public int deleteUser(Integer id) {
        return userEntityMapper.deleteByPrimaryKey(id);
    }
}
