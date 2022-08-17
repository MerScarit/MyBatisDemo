package com.scarit.Dao.impl;

import com.scarit.Dao.UserDao;
import com.scarit.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDaoImpl implements UserDao  {
    @Override
    public List<User> selectAll() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<Object> objects = session.selectList(UserDao.class.getName() + "." + "selectAll");
            System.out.println(objects);
        }
        return null;
    }

    @Override
    public User selectOne(int id) {
        return null;
    }

    @Override
    public int insert(User user) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }


    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        userDao.selectAll();
    }
}
