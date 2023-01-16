package com.susu.mybatis.test;

import com.susu.mybatis.mapper.SelectMapper;
import com.susu.mybatis.mapper.UserMapper;
import com.susu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.SqlSessionUtil;

import javax.swing.*;
import java.util.List;
import java.util.Map;

/**
 * 苏旻
 */
public class SelectMapperTest {
    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper Mapper = sqlSession.getMapper(SelectMapper.class);
        User user = Mapper.getUserById(1);
        System.out.println(user);
    }
    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper Mapper = sqlSession.getMapper(SelectMapper.class);
       List<User> user = Mapper.getAllUser();
        user.forEach(System.out::println);
    }
    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper Mapper = sqlSession.getMapper(SelectMapper.class);
       Integer count = Mapper.getCount();
        System.out.println(count);
    }
    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper Mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = Mapper.getUserByIdToMap(1);
      //  {password=123456, gender=男, id=1, emall=123456@qq.com, age=23, username=admin}

        System.out.println(map);
    }
    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper Mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = Mapper.getAllUserToMap();
        System.out.println(map);
//        List<Map<String, Object>> list = Mapper.getAllUserToMap();
//        System.out.println(list);
    }


    }
