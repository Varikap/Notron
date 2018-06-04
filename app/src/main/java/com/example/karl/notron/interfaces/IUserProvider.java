package com.example.karl.notron.interfaces;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.karl.notron.model.User;

import java.util.List;

public interface IUserProvider {
    long add(@NonNull User user);
    void delete(@NonNull User user);
    void update(@NonNull User user);
    List<User> loadUsers();
    @Nullable
    Bitmap loadPhoto(final String photoPath);
}
