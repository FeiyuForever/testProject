package com.feiyu.data.ocean.service;

import com.feiyu.data.ocean.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author xzhou.James
 * @Date 2020/2/14  9:30
 */
public interface UserService {

    List<User> userList(int pageIndex,int pageSize);
}
