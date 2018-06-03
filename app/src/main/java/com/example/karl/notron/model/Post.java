package com.example.karl.notron.model;

import android.graphics.Bitmap;

import java.util.Date;
import java.util.List;

public class Post {
    private int id;
    private String title;
    private String description;
    private Bitmap photo;
    private User author;
    private Date date;
    private double longitude;
    private double latitude;
    private List<Tag> tags;
    private List<Comment> comments;
    private int likes;
    private int dislikes;

    public Post(){

    }

    public Post(int id, String title, String description, Bitmap photo, User author, Date date, double longitude, double latitude, List<Tag> tags, List<Comment> comments, int likes, int dislikes) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.author = author;
        this.date = date;
        this.longitude = longitude;
        this.latitude = latitude;
        this.tags = tags;
        this.comments = comments;
        this.likes = likes;
        this.dislikes = dislikes;
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

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
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
}
