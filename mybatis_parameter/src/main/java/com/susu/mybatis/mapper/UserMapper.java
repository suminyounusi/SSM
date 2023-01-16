package com.susu.mybatis.mapper;

import com.susu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

/**
 * 苏旻
 * MyBatis获取参数值的两种方式：#{}和${}
 * 1、若mapper接口方法的参数为单个的字面量类型
 * 此时可以通过#{}和${}以任意内容获取参数值，一定要注意${}的单引号问题
 * 2、若mapper接口方法的擦描述为多个的字面量类型
 * 此时MyBatis会将参数放在map集合中，以两种方式存储数据
 * a>以arg0,arg1...为键，以参数为值
 * b>以param1.param2。。。为键，以参数为值
 * 3、若mapper接口方法的参数是map集合类型的参数
 * 此时可以通过#{}和${}以任意内容获取参数值，一定要注意${}的单引号问题
 * 4、若mapper接口方法的擦描述为实体类类型的参数
 *  此时可以通过#{}和${}以任意内容获取参数值，一定要注意${}的单引号问题
 *  5、可以在mapper接口方法的参数上设置@param注解
 *  此时MyBatis会将这些参数放在map中，以两种方式进行存储
 */
public interface UserMapper {
    /**
     * 根据用户名查询信息
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    /**
     * 验证登录
     * @param username
     * @param password
     * @return
     */

    User checkLogin(String username, String password);

    /**
     * 验证登录（以map集合传值）
     * @param map
     * @return
     */
    User checkLoginByMap(HashMap<String, Object> map);

    /**
     * 添加用户信息
     * @param user
     */
    void insertUser(User user);

    /**
     * 验证登录（使用@param）
     * @param username
     * @param password
     * @return
     */
    User checkLoginByParam(@Param("username") String username, @Param("password")String password);
}
