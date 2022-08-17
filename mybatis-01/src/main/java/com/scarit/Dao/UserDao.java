package com.scarit.Dao;

import com.scarit.entity.User;

import java.util.List;

public interface UserDao {
    List<User> selectAll();
}
