package com.example.karl.notron.model;

import java.util.ArrayList;
import java.util.List;

public class Tag {
    private int id;
    private String name;
    private List<Post> posts;
    private int postId;

    public Tag(int id, String name, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.posts = posts;
    }

    public Tag(int id, String name, int postId) {
        this.id = id;
        this.name = name;
        this.postId = postId;
    }



    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
