package com.robin.hrm.dao;

import com.robin.hrm.dao.provider.DeptDynaSqlProvider;
import com.robin.hrm.domain.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

import static com.robin.hrm.util.common.HrmConstants.DEPTTABLE;

public interface DeptDao {
    @SelectProvider(type = DeptDynaSqlProvider.class, method = "selectWithParam")
    List<Dept> selectByPage(Map<String, Object> params);

    @SelectProvider(type = DeptDynaSqlProvider.class, method = "count")
    Integer count(Map<String, Object> params);

    @Select("select * from " + DEPTTABLE + " ")
    List<Dept> selectAllDept();

    @Select("select * from " + DEPTTABLE + " where id = #{id}")
    Dept selectById(int id);

    @Delete("delete from " + DEPTTABLE + " where id = #{id}")
    void deleteById(Integer id);

    //动态插入部门
    @InsertProvider(type = DeptDynaSqlProvider.class, method = "insertDept")
    void save(Dept dept);

    //动态修改部门
    @UpdateProvider(type = DeptDynaSqlProvider.class, method = "updateDept")
    void update(Dept dept);
}
