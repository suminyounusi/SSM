package com.susu.mybatis.mapper;

import com.susu.mybatis.pojo.User;

import java.util.List;

/**
 * 苏旻
 */
public interface UserMapper {
    /**
     * 添加用户信息
     * @return
     */
    int insertUser();

    /**
     * 修改用户信息
     */
  void updateUser();

    /**
     * 删除用户信息
     */
  void deleteUser();

    /**
     * 根据id查询用户信息
     * @return
     */
  User getUserById();

    /**
     * 查询所有用户信息
     * @return
     */
  List<User> getAllUser();

}
