package com.susu.mybatis.mapper;

import com.susu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 苏旻
 */
public interface SelectMapper {
    /**
     *通过id查询信息
     * @param id
     * @return
     */
    User getUserById(@Param("id") Integer id);

    /**
     * 查询所以用户信息
     * @return
     */

    List<User> getAllUser();

    /**
     * 查询用户总数
     * @return
     */

    Integer getCount();

    /**
     * 根据id查询用户信息为map集合
     * @param id
     * @return
     */
    Map<String, Object> getUserByIdToMap(@Param("id")Integer id);

    /**
     * 查询所有用户信息为map集合
     * 若查询的数据有多条时，并且要将每条数据转换为map集合
     * 此时有两种解决方案
     * 1、将mapper接口方法的返回值设置为泛型是map的list集合
     * 2、使用注解@MapKey()来设置键为id
     * @return
     */
   // List<Map<String, Object>> getAllUserToMap();
    @MapKey("id")
    Map<String, Object> getAllUserToMap();

}
