package com.robin.hrm.dao;

import com.robin.hrm.dao.provider.EmployeeDynaSqlProvider;
import com.robin.hrm.domain.Employee;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

import static com.robin.hrm.util.common.HrmConstants.EMPLOYEETABLE;

public interface EmployeeDao {
    //根据参数查询员工总数
    @SelectProvider(type = EmployeeDynaSqlProvider.class, method = "count")
    Integer count(Map<String, Object> params);

    //根据参数动态查询员工
    @SelectProvider(type = EmployeeDynaSqlProvider.class, method = "selectWithParam")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "card_id", property = "cardId"),
            @Result(column = "post_code", property = "postCode"),
            @Result(column = "qq_num", property = "qqNum"),
            @Result(column = "birthday", property = "birthday", javaType = java.util.Date.class),
            @Result(column = "create_date", property = "createDate", javaType = java.util.Date.class),
            @Result(column = "dept_id", property = "dept",
                    one = @One(select = "com.robin.hrm.dao.DeptDao.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "job_id", property = "job",
                    one = @One(select = "com.robin.hrm.dao.JobDao.selectById", fetchType = FetchType.EAGER))
    })
    List<Employee> selectByPage(Map<String, Object> params);

    //动态插入员工
    @InsertProvider(type = EmployeeDynaSqlProvider.class, method = "insertEmployee")
    Boolean save(Employee employee);

    //根据id删除员工
    @Delete("delete from " + EMPLOYEETABLE + " where id = #{id}")
    Boolean deleteById(Integer id);

    //根据id查询员工
    @Select("select * from " + EMPLOYEETABLE + " where id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "card_id", property = "cardId"),
            @Result(column = "post_code", property = "postCode"),
            @Result(column = "qq_num", property = "qqNum"),
            @Result(column = "birthday", property = "birthday", javaType = java.util.Date.class),
            @Result(column = "create_date", property = "createDate", javaType = java.util.Date.class),
            @Result(column = "dept_id", property = "dept",
                    one = @One(select = "com.robin.hrm.dao.DeptDao.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "job_id", property = "job",
                    one = @One(select = "com.robin.hrm.dao.JobDao", fetchType = FetchType.EAGER))
    })
    Employee selectById(Integer id);

    //动态修改员工
    @UpdateProvider(type = EmployeeDynaSqlProvider.class, method = "updateEmployee")
    Boolean update(Employee employee);
}
