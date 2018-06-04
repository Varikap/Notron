package com.example.karl.notron.interfaces;

import android.support.annotation.NonNull;

import com.example.karl.notron.model.Post;

import java.util.List;

public interface IPostProvider {
    long add(@NonNull Post post);
    void delete(@NonNull Post post);
    void update(@NonNull Post post);
    List<Post> loadPosts();
}
