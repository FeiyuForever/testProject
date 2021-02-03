package com.feiyu.data.service;

import com.feiyu.data.MavenApplication;
import com.feiyu.data.ocean.model.Post;
import com.feiyu.data.ocean.model.User;
import com.feiyu.data.ocean.service.PostService;
import com.feiyu.data.ocean.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author xzhou.James
 * @Date 2020/2/14  9:34
 */
@SpringBootTest(classes = MavenApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Test
    public void TestService(){
        List<User> userList  = userService.userList(0,5);
        for(User user:userList){
            System.out.println(user.getUser_name()+":"+user.getUser_password());
        }
    }

    @Test
    public void TestPostService(){
        List<Post> postList  = postService.findPostList();
        System.out.println(postList);
    }
}
