package com.example.karl.notron.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.karl.notron.database.user.UserCursorWrapper;
import com.example.karl.notron.database.user.UserDatabaseHelper;
import com.example.karl.notron.database.user.UserDbSchema;
import com.example.karl.notron.interfaces.IUserProvider;
import com.example.karl.notron.model.User;
import com.example.karl.notron.database.user.UserDbSchema.UserTable.Cols;



import java.util.ArrayList;
import java.util.List;

public class UserProvider implements IUserProvider {
    private Context mContext;
    private SQLiteDatabase mDatabase;

    UserProvider(Context context){
        mContext = context;
        mDatabase = new UserDatabaseHelper(context).getWritableDatabase();
    }

    /**
     * <p> If -1 is returned then data could not be inserted. </p>
     * @param user
     * @return
     */
    @Override
    public long add(@NonNull User user) {
        return mDatabase.insertOrThrow(UserDbSchema.UserTable.TABLE_NAME, null, getContentValues(user));
    }

    @Override
    public void delete(@NonNull User user) {
        mDatabase.delete(UserDbSchema.UserTable.TABLE_NAME, Cols.ID+" = ?", new String[]{String.valueOf(user.getId())});
    }

    @Override
    public void update(@NonNull User user) {
        ContentValues values = getContentValues(user);
        mDatabase.update(UserDbSchema.UserTable.TABLE_NAME, values, Cols.ID + " = ?", new String[]{String.valueOf(user.getId())});
    }

    @Override
    public List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        // select all.
        UserCursorWrapper cursor = queryCursor(null, null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                users.add(cursor.getSubject());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }

        return users;
    }

    @Nullable
    @Override
    public Bitmap loadPhoto(String photoPath) {
        return null;
    }

    /**
     * @param whereClaus
     * @param whereArgs
     * @return cursor for the passed parameters.
     */
    private UserCursorWrapper queryCursor(@Nullable String whereClaus, @Nullable String[] whereArgs) {

        Cursor cursor = mDatabase.query(
                UserDbSchema.UserTable.TABLE_NAME,
                null, // Columns - null means select all columns
                whereClaus,
                whereArgs,
                null, // group by
                null, // having
                null // order by
        );

        return new UserCursorWrapper(cursor);
    }

    private static ContentValues getContentValues(User subject) {
        ContentValues values = new ContentValues();
        values.put(Cols.NAME, subject.getName());
        values.put(Cols.USERNAME, subject.getUsername());
        values.put(Cols.PASSWORD, subject.getPassword());
        values.put(Cols.PHOTO_PATH, subject.getPhotoPath());
        return values;
    }
}
