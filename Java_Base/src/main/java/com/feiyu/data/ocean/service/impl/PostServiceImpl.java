package com.feiyu.data.ocean.service.impl;

import com.feiyu.data.ocean.model.Post;
import com.feiyu.data.ocean.repository.PostRepository;
import com.feiyu.data.ocean.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author xzhou.James
 * @Date 2020/4/6  20:02
 */
@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> findPostList() {
        List<Post> postList = postRepository.findPostList();
        return postList;
    }
}
