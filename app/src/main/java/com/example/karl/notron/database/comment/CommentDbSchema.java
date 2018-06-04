package com.example.karl.notron.database.comment;

public class CommentDbSchema {
    public static final class CommentTable {
        public static final String  TABLE_NAME = "comments";

        public static final class Cols {
            public static final String ID = "id";
            public static final String TITLE = "title";
            public static final String DESCRIPTION = "description";
            public static final String USER_ID = "user_id";
            public static final String POST_ID = "post_id";
            public static final String DATE = "date";
            public static final String LIKES = "likes";
            public static final String DISLIKES = "dislikes";
        }
    }
}
