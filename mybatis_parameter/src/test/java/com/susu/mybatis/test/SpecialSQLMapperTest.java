package com.susu.mybatis.test;

import com.susu.mybatis.mapper.SpecialSQLMapper;
import com.susu.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.SqlSessionUtil;
import java.util.List;

/**
 * 苏旻
 */
public class SpecialSQLMapperTest {
    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> list = mapper.getUserByLike("a");
       list.forEach(System.out::println);

    }
    @Test
    public void testDeleteMoreUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
       mapper.deleteMoreUser("5,10");
    }
    @Test
    public void testGetUserList(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> user = mapper.getUserList("t_user");
      user.forEach(System.out::println);
    }
    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
       User user = new User(null,"xiaoming", "123456", 23, "男", "111@qq.com");
       mapper.insertUser(user);

        System.out.println(user);
    }
}
