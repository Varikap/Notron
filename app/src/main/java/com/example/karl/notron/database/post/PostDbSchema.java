package com.example.karl.notron.database.post;

public class PostDbSchema {
    public static final class PostTable {
        public static final String TABLE_NAME = "posts";

        public static final class Cols {
            public static final String ID = "id";
            public static final String TITLE = "title";
            public static final String DESCRIPTION = "description";
            public static final String PHOTO_PATH = "photo_path";
            public static final String USER_ID = "user_id";
            public static final String DATE = "date";
            public static final String LIKES = "likes";
            public static final String DISLIKES = "dislikes";
        }
    }
}
