package com.example.karl.notron.database.user;

public class UserDbSchema {
    public static final class UserTable {
        public static final String TABLE_NAME = "subjects";

        public static final class Cols {
            public static final String ID = "id";
            public static final String NAME = "name";
            public static final String PHOTO_PATH = "photo_path";
            public static final String USERNAME = "username";
            public static final String PASSWORD = "password";
        }
    }
}
