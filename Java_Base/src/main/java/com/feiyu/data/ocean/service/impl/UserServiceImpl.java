package com.feiyu.data.ocean.service.impl;

import com.feiyu.data.ocean.model.User;
import com.feiyu.data.ocean.repository.UserRepository;
import com.feiyu.data.ocean.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xzhou.James
 * @Date 2020/2/14  9:31
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> userList(int pageIndex, int pageSize) {
        List<User> userList = new ArrayList<>();
        List<User> userList1 = userRepository.userList1(pageIndex,pageSize);
        List<User> userList2 =  userRepository.userList2(pageIndex,pageSize);
        userList.addAll(userList1);
        userList.addAll(userList2);
        return userList;
    }
}
