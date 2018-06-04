package com.example.karl.notron.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.karl.notron.database.comment.CommentCursorWrapper;
import com.example.karl.notron.database.comment.CommentDatabaseHelper;
import com.example.karl.notron.database.comment.CommentDbSchema;
import com.example.karl.notron.interfaces.ICommentProvider;
import com.example.karl.notron.model.Comment;


import java.util.ArrayList;
import java.util.List;


public class CommentProvider implements ICommentProvider {
    private Context mContext;
    private SQLiteDatabase mDatabase;

    CommentProvider (Context context) {
        mContext = context;
        mDatabase = new CommentDatabaseHelper(context).getWritableDatabase();
    }

    @Override
    public long add(@NonNull Comment comment) {
        return mDatabase.insertOrThrow(CommentDbSchema.CommentTable.TABLE_NAME, null, getContentValues(comment));
    }

    @Override
    public void delete(@NonNull Comment comment) {
        mDatabase.delete(CommentDbSchema.CommentTable.TABLE_NAME,  CommentDbSchema.CommentTable.Cols.ID + " = ?", new String[] {String.valueOf(comment.getId())});
    }

    @Override
    public void update(@NonNull Comment comment) {
        ContentValues values = getContentValues(comment);
        mDatabase.update(CommentDbSchema.CommentTable.TABLE_NAME, values, CommentDbSchema.CommentTable.Cols.ID + " = ?", new String[]{String.valueOf(comment.getId())});
    }

    @Override
    public List<Comment> loadComments() {
        List<Comment> comments  = new ArrayList<>();
        CommentCursorWrapper cursor = queryCursor(null,null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                comments.add(cursor.getComment());
                cursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return comments;
    }

    private CommentCursorWrapper queryCursor(@Nullable String whereClaus, @Nullable String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                CommentDbSchema.CommentTable.TABLE_NAME,
                null, // Columns - null means select all columns
                whereClaus,
                whereArgs,
                null, // group by
                null, // having
                null // order by
        );

        return new CommentCursorWrapper(cursor);
    }

    private static ContentValues getContentValues (Comment comment) {
        ContentValues values = new ContentValues();
        values.put(CommentDbSchema.CommentTable.Cols.TITLE, comment.getTitle());
        values.put(CommentDbSchema.CommentTable.Cols.DESCRIPTION, comment.getDescription());
        values.put(CommentDbSchema.CommentTable.Cols.POST_ID, comment.getPostId());
        values.put(CommentDbSchema.CommentTable.Cols.USER_ID, comment.getAuthorId());
        values.put(CommentDbSchema.CommentTable.Cols.DATE, comment.getDate().toString());
        values.put(CommentDbSchema.CommentTable.Cols.LIKES, comment.getLikes());
        values.put(CommentDbSchema.CommentTable.Cols.DISLIKES, comment.getDislikes());
        return values;
    }
}
