package com.feiyu.data.ocean.repository;

import com.feiyu.data.ocean.model.Post;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author xzhou.James
 * @Date 2020/4/6  19:59
 */
@Repository
public interface PostRepository {

    @Select("select post_id,post_topic,post_context,post_publishtime from post limit 10")
    List<Post> findPostList();
}
