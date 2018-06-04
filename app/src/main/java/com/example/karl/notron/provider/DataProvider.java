package com.example.karl.notron.provider;

import android.content.Context;

public class DataProvider {
    private static DataProvider sSingletone;
    private Context mContext;
    private UserProvider mUserProvider;
    private PostProvider mPostProvider;
    private CommentProvider mCommentProvider;
    private TagProvider mTagProvider;

    public DataProvider(Context context) {
        mContext = context;
        mUserProvider = new UserProvider(mContext);
        mPostProvider = new PostProvider(mContext);
        mCommentProvider = new CommentProvider(mContext);
        mTagProvider = new TagProvider(mContext);
    }

    public static DataProvider getSingletone(Context context) {
        if (sSingletone == null)
            sSingletone = new DataProvider(context);

        return sSingletone;
    }

    public UserProvider getUserProvider() {
        return mUserProvider;
    }

    public PostProvider getPostProvider() {
        return mPostProvider;
    }

    public CommentProvider getCommentProvider() {
        return mCommentProvider;
    }

    public TagProvider getTagProvider() {
        return mTagProvider;
    }
}
