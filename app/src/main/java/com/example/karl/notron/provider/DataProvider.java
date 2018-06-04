package com.example.karl.notron.provider;

import android.content.Context;

import com.example.karl.notron.provider.user.UserProvider;

public class DataProvider {
    private static DataProvider sSingletone;
    private Context mContext;
    private UserProvider mUserProvider;

    public DataProvider(Context context) {
        mContext = context;
        mUserProvider = new UserProvider(mContext);
    }

    public static DataProvider getSingletone(Context context) {
        if (sSingletone == null)
            sSingletone = new DataProvider(context);

        return sSingletone;
    }

    public UserProvider getUserProvider() {
        return mUserProvider;
    }
}
