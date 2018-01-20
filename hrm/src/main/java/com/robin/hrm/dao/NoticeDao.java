package com.robin.hrm.dao;

import com.robin.hrm.dao.provider.NoticeDynaSqlProvider;
import com.robin.hrm.domain.Notice;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

import static com.robin.hrm.util.common.HrmConstants.NOTICETABLE;

public interface NoticeDao {
    //动态查询
    @SelectProvider(type = NoticeDynaSqlProvider.class, method = "selectWithParam")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "create_date", property = "createDate", javaType = java.util.Date.class),
            @Result(column = "user_id", property = "user", one = @One(select = "com.robin.hrm.dao.UserDao.selectById", fetchType = FetchType.EAGER))
    })
    List<Notice> selectByPage(Map<String, Object> params);

    @SelectProvider(type = NoticeDynaSqlProvider.class, method = "count")
    Integer count(Map<String, Object> params);

    @Select("select * from " + NOTICETABLE + "where id = #{id}")
    Notice selectById(int id);

    @Delete("delete from " + NOTICETABLE + "where id = #{id}")
    void deleteById(int id);

    @InsertProvider(type = NoticeDynaSqlProvider.class, method = "insertNotice")
    void save(Notice notice);

    @UpdateProvider(type = NoticeDynaSqlProvider.class, method = "updateNotice")
    void update(Notice notice);
}
