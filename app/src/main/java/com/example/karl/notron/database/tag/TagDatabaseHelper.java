package com.example.karl.notron.database.tag;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.karl.notron.database.user.UserDbSchema;

public class TagDatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "UserDatabaseHelper";
    private static final String DATABASE_NAME = "tagsDatabase.db";
    private static final int VERSION = 1;

    public TagDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TagDbSchema.TagTable.TABLE_NAME + "(" +
                " " + TagDbSchema.TagTable.Cols.ID + " integer primary key autoincrement, " +
                TagDbSchema.TagTable.Cols.NAME + ", " +
                TagDbSchema.TagTable.Cols.POST_ID +
        ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.i(TAG, "upgrade called old version: " + String.valueOf(oldVersion) + " new version: " + String.valueOf(newVersion));
    }
}
