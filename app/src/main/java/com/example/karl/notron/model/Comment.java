package com.example.karl.notron.model;

import android.os.AsyncTask;

import java.lang.String;

public class Comment {
    private int id;
    private String title;
    private String description;
    private User author;
    private int authorId;
    private String date;
    private Post post;
    private int postId;
    private int likes;
    private int dislikes;
    private AsyncTask.Status status;

    public Comment(){

    }

    public Comment(int id, String title, String description, int authorId, String date, int postId, int likes, int dislikes) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.authorId = authorId;
        this.date = date;
        this.postId = postId;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public Comment(int id, String title, String description, User author, String date, Post post, int likes, int dislikes, AsyncTask.Status status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.date = date;
        this.post = post;
        this.likes = likes;
        this.dislikes = dislikes;
        this.status = status;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public AsyncTask.Status getStatus() {
        return status;
    }

    public void setStatus(AsyncTask.Status status) {
        this.status = status;
    }
}
