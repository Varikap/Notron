package com.example.karl.notron.database.post;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.karl.notron.model.Post;
import com.example.karl.notron.database.post.PostDbSchema.PostTable.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PostCursorWrapper extends CursorWrapper {
    public PostCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Post getPost() {
        try {

            int id = Integer.parseInt(getString(getColumnIndex(Cols.ID)));
            String title = getString(getColumnIndex(Cols.TITLE));
            String description = getString(getColumnIndex(Cols.DESCRIPTION));
            String photo_path = getString(getColumnIndex(Cols.PHOTO_PATH));
            int userId = Integer.parseInt(getString(getColumnIndex(Cols.USER_ID)));
            String string_date = getString(getColumnIndex(Cols.DATE));
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(string_date);
            int likes = Integer.parseInt(getString(getColumnIndex(Cols.LIKES)));
            int dislikes = Integer.parseInt(getString(getColumnIndex(Cols.DISLIKES)));
            return new Post(id, title, description, photo_path, userId, date, likes, dislikes);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
