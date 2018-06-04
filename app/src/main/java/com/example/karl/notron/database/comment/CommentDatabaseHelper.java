package com.example.karl.notron.database.comment;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.karl.notron.database.comment.CommentDbSchema.CommentTable.*;



public class CommentDatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "CommentDatabaseHelper";
    public static final String DATABASE_NAME = "commentDatabase.db";
    public static final int VERSION = 1;

    public  CommentDatabaseHelper (Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + CommentDbSchema.CommentTable.TABLE_NAME + "(" +
                " " + Cols.ID + "integer primary key autoincrement, " +
                Cols.TITLE + ", " +
                Cols.DESCRIPTION + ", " +
                Cols.POST_ID + ", " +
                Cols.USER_ID + ", " +
                Cols.DATE + ", " +
                Cols.LIKES + ", " +
                Cols.DISLIKES +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.i(TAG, "upgrade called old version: " + String.valueOf(oldVersion) + " new version: " + String.valueOf(newVersion));
    }
}
