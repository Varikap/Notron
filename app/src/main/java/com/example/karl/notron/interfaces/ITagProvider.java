package com.example.karl.notron.interfaces;

import android.support.annotation.NonNull;

import com.example.karl.notron.model.Tag;

import java.util.List;

public interface ITagProvider {
    long add(@NonNull Tag tag);
    void delete(@NonNull Tag tag);
    void update(@NonNull Tag tag);
    List<Tag> loadTags();
}
