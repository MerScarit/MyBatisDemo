package com.scarit.Dao;

import com.scarit.entity.User;

import java.util.List;

public interface UserDao {

    //查询所有用户
    List<User> selectAll();

    //根据ID查询用户
    User selectOne(int id);

    //添加用户
    int insert(User user);

    //更新
    int update(User user);

    //删除
    int delete(int id);

}
