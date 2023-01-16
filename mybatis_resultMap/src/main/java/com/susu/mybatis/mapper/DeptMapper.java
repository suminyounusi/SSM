package com.susu.mybatis.mapper;

import com.susu.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * 苏旻
 */
public interface DeptMapper {
    /**
     * 通过分步查询来查询员工消息及部门信息的第2步
     * @param deptId
     * @return
     */
    Dept getEmpAndDeptByStepOne(@Param("deptId") Integer deptId);

    /**
     * 查询部门以及部门员工信息
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByDeptId(@Param("deptId") Integer deptId);

    /**
     * 通过分步查询部门以及部门中的员工信息的第一步
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByStepOne(@Param("deptId") Integer deptId);


}
