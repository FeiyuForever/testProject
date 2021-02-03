package com.feiyu.data.ocean.repository;

import com.feiyu.data.ocean.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author xzhou.James
 * @Date 2020/2/14  9:26
 */
@Repository
public interface UserRepository {

    @Select("select user_name,user_password,user_sex from user limit #{pageIndex},#{pageSize}")
    List<User> userList1(@Param("pageIndex")int pageIndex,
                        @Param("pageSize")int pageSize);

    @Select("select user_name,user_password,user_sex from user limit #{pageIndex},#{pageSize}")
    List<User> userList2(@Param("pageIndex")int pageIndex,
                        @Param("pageSize")int pageSize);
}
