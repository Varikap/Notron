package com.example.karl.notron.interfaces;

import android.support.annotation.NonNull;

import com.example.karl.notron.model.Comment;

import java.util.List;

public interface ICommentProvider {
    long add(@NonNull Comment comment);
    void delete(@NonNull Comment comment);
    void update(@NonNull Comment comment);
    List<Comment> loadComments();
}
