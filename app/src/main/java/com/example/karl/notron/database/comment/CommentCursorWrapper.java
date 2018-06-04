package com.example.karl.notron.database.comment;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.karl.notron.database.comment.CommentDbSchema.CommentTable.*;
import com.example.karl.notron.model.Comment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CommentCursorWrapper extends CursorWrapper {
    public CommentCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Comment getComment() {

            int id = Integer.parseInt(getString(getColumnIndex(Cols.ID)));
            String title = getString(getColumnIndex(Cols.TITLE));
            String description = getString(getColumnIndex(Cols.DESCRIPTION));
            int userId = Integer.parseInt(getString(getColumnIndex(Cols.USER_ID)));
            String string_date = getString(getColumnIndex(Cols.DATE));
            int post_id = Integer.parseInt(getString(getColumnIndex(Cols.POST_ID)));
            int likes = Integer.parseInt(getString(getColumnIndex(Cols.LIKES)));
            int dislikes = Integer.parseInt(getString(getColumnIndex(Cols.DISLIKES)));


//            Calendar calendar = Calendar.getInstance();
//            Date now = new Date();
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
//            Date d = simpleDateFormat.parse(string_date);

            return new Comment(id, title, description, userId, string_date, post_id,likes,dislikes);
    }
}
