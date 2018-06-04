package com.example.karl.notron.database.user;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.karl.notron.database.user.UserDbSchema.UserTable.*;

public class UserDatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "UserDatabaseHelper";
    private static final String DATABASE_NAME = "userDatabase.db";
    private static final int VERSION = 1;

    public UserDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + UserDbSchema.UserTable.TABLE_NAME + "(" +
                " " + Cols.ID + " integer primary key autoincrement, " +
                Cols.NAME + ", " +
                Cols.USERNAME + ", " +
                Cols.PHOTO_PATH + ", " +
                Cols.PASSWORD +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.i(TAG, "upgrade called old version: " + String.valueOf(oldVersion) + " new version: " + String.valueOf(newVersion));
    }

}
