package com.example.karl.notron.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.karl.notron.R;
import com.example.karl.notron.model.User;
import com.example.karl.notron.provider.DataProvider;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button b = (Button) findViewById(R.id.buttonLogin);
        b.setOnClickListener(listener);
    }

    public void test(){

        Log.d(TAG, "test: ADDDDD ");
        for (int i=0; i<100; i++) {
            User u = new User("Name: "+i, "Username: "+i, "Password", "Photo path");
            DataProvider.getSingletone(getApplicationContext()).getUserProvider().add(u);
        }


        Log.d(TAG, "test: LOADDDD ");
        List<User> list = DataProvider.getSingletone(getApplicationContext()).getUserProvider().loadUsers();
        Log.d(TAG, "test: "+list.size());
        for (User u : list) {
            Log.d(TAG, "test: "+u);
        }

        Log.d(TAG, "test: DELETEEE ");

        // delete first 20.
        for(int i=0; i<20; i++) {
            DataProvider.getSingletone(getApplicationContext()).getUserProvider().delete(list.get(i));
        }

        Log.d(TAG, "test: UPDATEE ");
        list.get(0).setName("Cevap");
        list.get(0).setUsername("cevap");
        DataProvider.getSingletone(getApplicationContext()).getUserProvider().update(list.get(0));

        Log.d(TAG, "test: LOADDDD ");
        list = DataProvider.getSingletone(getApplicationContext()).getUserProvider().loadUsers();
        for (User u : list) {
            Log.d(TAG, "test: "+u);
        }
        Log.d(TAG, "test: "+list.size());
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(LoginActivity.this, PostsActivity.class);
            startActivity(i);
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
