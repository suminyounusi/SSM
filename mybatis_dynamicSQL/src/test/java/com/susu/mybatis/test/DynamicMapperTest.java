package com.susu.mybatis.test;

import com.susu.mybatis.mapper.DynamicSQLMapper;
import com.susu.mybatis.pojo.Emp;
import com.susu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 苏旻
 */
public class DynamicMapperTest {
    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null, "苏景", 17, "" );
        List<Emp> list = mapper.getEmpByCondition(emp);
        list.forEach(System.out::println);
    }
    @Test
    public void testInsertMoreEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null, "冶福云", 22, "" );
        Emp emp2 = new Emp(null, "冶福祥", 27, "" );
        Emp emp3 = new Emp(null, "冶海燕", 21, "" );
        List<Emp> list = Arrays.asList(emp1, emp2, emp3);

        mapper.insertMoreEmp(list);
    }
    @Test
    public void testDeleteMoreEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null, "冶福云", 22, "" );
        Emp emp2 = new Emp(null, "冶福祥", 27, "" );
        Emp emp3 = new Emp(null, "冶海燕", 21, "" );
     Integer[] empIds = new Integer[]{6,7};

        mapper.deleteMoreEmp(empIds);
    }
}
