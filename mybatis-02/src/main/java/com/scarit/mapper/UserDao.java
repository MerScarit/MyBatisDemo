package com.scarit.mapper;

import com.scarit.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    //查询所有用户
    List<User> selectAll();

    //根据ID查询用户
    User selectOne(int id);

    //动态SQL
    //if语句
    List<User> findUser(User user);

    //添加用户
    int insert(User user);

    //更新
    int update(User user);

    //删除
    int delete(int id);

    //按ids批量删除
    int deleteByIds(@Param("ids") List<Integer> ids);

    //批量新增
    int batchInsert(@Param("users") List<User> users);

}
