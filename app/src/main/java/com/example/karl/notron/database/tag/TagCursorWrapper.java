package com.example.karl.notron.database.tag;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.karl.notron.model.Tag;
import com.example.karl.notron.database.tag.TagDbSchema.TagTable.Cols;

public class TagCursorWrapper extends CursorWrapper {
    public TagCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Tag getTag() {
        String id = getString(getColumnIndex(Cols.ID));
        String name = getString(getColumnIndex(Cols.NAME));
        String postId = getString(getColumnIndex(Cols.POST_ID));
        return new Tag(Integer.parseInt(id), name, Integer.parseInt(postId));
    }
}
