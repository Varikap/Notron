package com.example.karl.notron.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.karl.notron.database.tag.TagCursorWrapper;
import com.example.karl.notron.database.tag.TagDatabaseHelper;
import com.example.karl.notron.database.tag.TagDbSchema;
import com.example.karl.notron.interfaces.ITagProvider;
import com.example.karl.notron.model.Tag;
import com.example.karl.notron.database.tag.TagDbSchema.TagTable.*;

import java.util.ArrayList;
import java.util.List;

public class TagProvider implements ITagProvider {
    private Context mContext;
    private SQLiteDatabase mDatabase;

    TagProvider(Context context){
        mContext = context;
        mDatabase = new TagDatabaseHelper(context).getWritableDatabase();
    }

    @Override
    public long add(@NonNull Tag tag) {
        return mDatabase.insertOrThrow(TagDbSchema.TagTable.TABLE_NAME,null,getContentValues(tag));
    }

    @Override
    public void delete(@NonNull Tag tag) {
        mDatabase.delete(TagDbSchema.TagTable.TABLE_NAME, Cols.ID + " = ?", new String[]{String.valueOf(tag.getId())});
    }

    @Override
    public void update(@NonNull Tag tag) {
        ContentValues values = getContentValues(tag);
        mDatabase.update(TagDbSchema.TagTable.TABLE_NAME, values, Cols.ID + " = ?", new String[]{String.valueOf(tag.getId())});
    }

    @Override
    public List<Tag> loadTags() {
        List<Tag> tags = new ArrayList<>();
        TagCursorWrapper cursor = queryCursor(null,null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                tags.add(cursor.getTag());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return tags;
    }

    private TagCursorWrapper queryCursor(@Nullable String whereClaus, @Nullable String[] whereArgs) {
        Cursor cursor = mDatabase.query(TagDbSchema.TagTable.TABLE_NAME,
                null,
                whereClaus,
                whereArgs,
                null,
                null,
                null
        );
        return new TagCursorWrapper(cursor);
    }

    private static ContentValues getContentValues (Tag tags) {
        ContentValues values = new ContentValues();
        values.put(Cols.NAME, tags.getName());
        values.put(Cols.POST_ID,tags.getPostId());
        return values;
    }
}
