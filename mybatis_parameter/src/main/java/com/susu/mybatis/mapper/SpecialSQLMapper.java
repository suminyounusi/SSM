package com.susu.mybatis.mapper;

import com.susu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 苏旻
 */
public interface SpecialSQLMapper {
    /**
     * 通过模糊查询
     *
     * @param mohu
     * @return
     */
    List<User> getUserByLike(@Param("mohu") String mohu);

    /**
     * 批量删除
     *
     * @param ids
     */
    void deleteMoreUser(@Param("ids") String ids);

    /**
     * 动态设置表名，查询信息
     *
     * @param table
     * @return
     */
    List<User> getUserList(@Param("tableName") String table);

    /**
     * 添加用户信息并获取自增主键
     *
     * @param user
     */
    void insertUser(User user);


}
