package model;

import android.os.AsyncTask;

import java.util.Date;

public class Comment {
    private int id;
    private String title;
    private String description;
    private User author;
    private Date date;
    private Post post;
    private int likes;
    private int dislikes;
    private AsyncTask.Status status;
}
