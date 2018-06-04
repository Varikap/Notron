package com.example.karl.notron.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.karl.notron.database.post.PostCursorWrapper;
import com.example.karl.notron.database.post.PostDatabaseHelper;
import com.example.karl.notron.database.post.PostDbSchema;
import com.example.karl.notron.database.user.UserDbSchema;
import com.example.karl.notron.interfaces.IPostProvider;
import com.example.karl.notron.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostProvider implements IPostProvider{
    private Context mContext;
    private SQLiteDatabase mDatabase;

    PostProvider (Context context) {
        mContext = context;
        mDatabase = new PostDatabaseHelper(context).getWritableDatabase();
    }

    @Override
    public long add(@NonNull Post post) {
        return mDatabase.insertOrThrow(PostDbSchema.PostTable.TABLE_NAME, null, getContentValues(post));
    }

    @Override
    public void delete(@NonNull Post post) {
        mDatabase.delete(PostDbSchema.PostTable.TABLE_NAME, UserDbSchema.UserTable.Cols.ID+" = ?", new String[]{String.valueOf(post.getId())});
    }

    @Override
    public void update(@NonNull Post post) {
        ContentValues values = getContentValues(post);
        mDatabase.update(PostDbSchema.PostTable.TABLE_NAME, values, PostDbSchema.PostTable.Cols.ID + " = ?", new String[]{String.valueOf(post.getId())});
    }

    @Override
    public List<Post> loadPosts() {
        List<Post> posts = new ArrayList<>();
        PostCursorWrapper cursor = queryCursor(null,null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                posts.add(cursor.getPost());
                cursor.moveToNext();
            }
        }
            finally {
                cursor.close();
            }

            return posts;
    }

    private PostCursorWrapper queryCursor(@Nullable String whereClaus, @Nullable String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                UserDbSchema.UserTable.TABLE_NAME,
                null, // Columns - null means select all columns
                whereClaus,
                whereArgs,
                null, // group by
                null, // having
                null // order by
        );

        return new PostCursorWrapper(cursor);
    }

    private static ContentValues getContentValues (Post post) {
        ContentValues values = new ContentValues();
        values.put(PostDbSchema.PostTable.Cols.TITLE, post.getTitle());
        values.put(PostDbSchema.PostTable.Cols.DESCRIPTION, post.getDescription());
        values.put(PostDbSchema.PostTable.Cols.PHOTO_PATH, post.getPhoto_path());
        values.put(PostDbSchema.PostTable.Cols.USER_ID, post.getAuthorId());
        values.put(PostDbSchema.PostTable.Cols.DATE, post.getDate().toString());
        values.put(PostDbSchema.PostTable.Cols.LIKES, post.getLikes());
        values.put(PostDbSchema.PostTable.Cols.DISLIKES, post.getDislikes());
        return values;
    }
}
