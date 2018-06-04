package com.example.karl.notron.database.tag;

public class TagDbSchema {
    public static final class TagTable {
        public static final String TABLE_NAME = "tags";

        public static final class Cols {
            public static final String ID = "id";
            public static final String NAME = "name";
            public static final String POST_ID = "post_id";
        }
    }
}
