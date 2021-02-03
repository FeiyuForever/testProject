package com.feiyu.data.ocean.model;

import java.util.Date;

/**
 * @Author xzhou.James
 * @Date 2020/4/6  19:55
 */
public class Post {

    private int post_id;
    private String post_topic;
    private String post_context;
    private Date post_publishtime;

    public Post() {
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getPost_topic() {
        return post_topic;
    }

    public void setPost_topic(String post_topic) {
        this.post_topic = post_topic;
    }

    public String getPost_context() {
        return post_context;
    }

    public void setPost_context(String post_context) {
        this.post_context = post_context;
    }

    public Date getPost_publishtime() {
        return post_publishtime;
    }

    public void setPost_publishtime(Date post_publishtime) {
        this.post_publishtime = post_publishtime;
    }
}
