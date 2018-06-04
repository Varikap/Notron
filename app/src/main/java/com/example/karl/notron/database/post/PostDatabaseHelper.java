package com.example.karl.notron.database.post;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.karl.notron.database.post.PostDbSchema.PostTable.Cols;

public class PostDatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "PostDatabaseHelper";
    public static final String DATABASE_NAME = "postDatabase.db";
    public static final int VERSION = 1;

    public PostDatabaseHelper (Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + PostDbSchema.PostTable.TABLE_NAME + "(" +
                " " + Cols.ID + "integer primary key autoincrement, " +
        Cols.TITLE + ", " +
        Cols.DESCRIPTION + ", " +
        Cols.PHOTO_PATH + ", " +
        Cols.USER_ID + ", " +
        Cols.DATE + ", " +
        Cols.LIKES + ", " +
        Cols.DISLIKES + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "upgrade called old version: " + String.valueOf(oldVersion) + " new version: " + String.valueOf(newVersion));
    }


}
