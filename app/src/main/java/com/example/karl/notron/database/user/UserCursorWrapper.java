package com.example.karl.notron.database.user;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.karl.notron.model.User;
import com.example.karl.notron.database.user.UserDbSchema.UserTable.*;

public class UserCursorWrapper extends CursorWrapper {
    public UserCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public User getSubject(){
        String id = getString(getColumnIndex(Cols.ID));
        String name = getString(getColumnIndex(Cols.NAME));
        String photo_path = getString(getColumnIndex(Cols.PHOTO_PATH));
        String username = getString(getColumnIndex(Cols.USERNAME));
        String password = getString(getColumnIndex(Cols.PASSWORD));
        return new User(Integer.parseInt(id),name,username, password, photo_path);
    }
}
