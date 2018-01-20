package com.robin.hrm.dao;

import com.robin.hrm.dao.provider.DocumentDynaSqlProvider;
import com.robin.hrm.domain.Document;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

import static com.robin.hrm.util.common.HrmConstants.DOCUMENTTABLE;

public interface DocumentDao {
    //动态查询
    @SelectProvider(type = DocumentDynaSqlProvider.class, method = "selectWithParam")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "create_date", property = "createDate", javaType = java.util.Date.class),
            @Result(column = "user_id", property = "user", one = @One(select = "com.robin.hrm.dao.UserDao.selectById", fetchType = FetchType.EAGER))
    })
    List<Document> selectByPage(Map<String, Object> params);

    @SelectProvider(type = DocumentDynaSqlProvider.class, method = "count")
    Integer count(Map<String, Object> params);

    @InsertProvider(type = DocumentDynaSqlProvider.class, method = "insertDocument")
    void save(Document document);

    @UpdateProvider(type = DocumentDynaSqlProvider.class, method = "updateDocument")
    void update(Document document);

    @Select("select * from " + DOCUMENTTABLE + " where id = #{id}")
    Document selectById(int id);

    @Delete("delete from" + DOCUMENTTABLE + " where id = #{id}")
    void deleteById(int id);
}
