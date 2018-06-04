package com.example.karl.notron.database.comment;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.karl.notron.database.comment.CommentDbSchema.CommentTable.*;
import com.example.karl.notron.model.Comment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommentCursorWrapper extends CursorWrapper {
    public CommentCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Comment getComment() {
        try {
            int id = Integer.parseInt(getString(getColumnIndex(Cols.ID)));
            String title = getString(getColumnIndex(Cols.TITLE));
            String description = getString(getColumnIndex(Cols.DESCRIPTION));
            int userId = Integer.parseInt(getString(getColumnIndex(Cols.USER_ID)));
            String string_date = getString(getColumnIndex(Cols.DATE));
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(string_date);
            int post_id = Integer.parseInt(getString(getColumnIndex(Cols.POST_ID)));
            int likes = Integer.parseInt(getString(getColumnIndex(Cols.LIKES)));
            int dislikes = Integer.parseInt(getString(getColumnIndex(Cols.DISLIKES)));

            return new Comment(id, title, description, userId, date, post_id,likes,dislikes);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
