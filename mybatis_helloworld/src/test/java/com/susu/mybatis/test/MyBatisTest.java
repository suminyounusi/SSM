package com.susu.mybatis.test;

import com.susu.mybatis.mapper.UserMapper;
import com.susu.mybatis.pojo.User;
import com.susu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 苏旻
 */
public class MyBatisTest {
    @Test
    public void testInsert() throws IOException {
        //获取核心配置的配置文件 ResourceAsStream 资源流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder（sql会话工厂构建）对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory
        SqlSessionFactory SqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取sql的会话对象SqlSession(不会自动提交事务)，是MyBatis提供的操作数据库对象
       // SqlSession sqlSession = SqlSessionFactory.openSession();
         //获取sql的会话对象SqlSession(会自动提交事务)，是MyBatis提供的操作数据库对象
        SqlSession sqlSession = SqlSessionFactory.openSession(true);
        //获取UserMapper的代理实现对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用mapper接口中的方法，实现添加用户信息的功能
        int result = mapper.insertUser();
        //提供sql以及唯一标识找到sql并执行，唯一标识是namespace.sqlId;
      //  int result = sqlSession.insert("com.susu.mapper.UserMapper.insertUser");
        System.out.println("结果" + result);
        //提交事务
      //  sqlSession.commit();

        //关闭sqlSession 会话是一个过程用完就关闭
        sqlSession.close();
    }
    @Test
    public void testUpdate(){
        SqlSession sqlsession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        mapper.updateUser();
        sqlsession.close();

    }
    @Test
    public void testdelete(){
        SqlSession sqlsession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        mapper.deleteUser();
        sqlsession.close();

    }
    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById();
        System.out.println(user);
    }
    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
       List<User> user = mapper.getAllUser();
       user.forEach(System.out::println);

    }

}
