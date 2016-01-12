package com.jlu.zhu.dao;

import com.jlu.zhu.entity.BlogEntity;

public interface BlogEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogEntity record);

    int insertSelective(BlogEntity record);

    BlogEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogEntity record);

    int updateByPrimaryKey(BlogEntity record);
}