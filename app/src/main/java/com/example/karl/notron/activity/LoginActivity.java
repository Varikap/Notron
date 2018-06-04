package com.example.karl.notron.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.karl.notron.R;
import com.example.karl.notron.model.Comment;
import com.example.karl.notron.model.Post;
import com.example.karl.notron.model.Tag;
import com.example.karl.notron.model.User;
import com.example.karl.notron.provider.DataProvider;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button b = (Button) findViewById(R.id.buttonLogin);
        b.setOnClickListener(listener);
        testUser();
        testComment();
        testPost();
        testTag();
    }

    public void testUser(){

        Log.d(TAG, "test: ADDDDD ");
        for (int i=0; i<10; i++) {
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
        for(int i=0; i<2; i++) {
            DataProvider.getSingletone(getApplicationContext()).getUserProvider().delete(list.get(i));
        }

        Log.d(TAG, "test: UPDATEE ");
        list.get(0).setName("Cevap");
        list.get(0).setUsername("cevap");
        DataProvider.getSingletone(getApplicationContext()).getUserProvider().update(list.get(0));

        Log.d(TAG, "test: LOADDDD ");
        list = DataProvider.getSingletone(getApplicationContext()).getUserProvider().loadUsers();
        for (User u : list) {
            Log.d(TAG, "test: "+u.getName());
        }
        Log.d(TAG, "test: "+list.size());
    }


    public void testTag () {
        Log.e(TAG, "test: ADDDDD TAAAG");
        for (int i=0; i<10; i++) {
            Tag u = new Tag(i, "Name" + i, i);
            DataProvider.getSingletone(getApplicationContext()).getTagProvider().add(u);
        }


        Log.e(TAG, "test: LOADDDD TAAAAG");
        List<Tag> list = DataProvider.getSingletone(getApplicationContext()).getTagProvider().loadTags();
        Log.d(TAG, "test: "+list.size());
        for (Tag u : list) {
            Log.d(TAG, "test: "+u);
        }

        Log.e(TAG, "test: DELETEEE TAAAG");
        for(int i=0; i<2; i++) {
            DataProvider.getSingletone(getApplicationContext()).getTagProvider().delete(list.get(i));
        }

        Log.e(TAG, "test: UPDATEE TAAAAG");
        list.get(0).setName("Cevap");
        DataProvider.getSingletone(getApplicationContext()).getTagProvider().update(list.get(0));

        Log.e(TAG, "test: LOADDDD TAAAAG");
        list = DataProvider.getSingletone(getApplicationContext()).getTagProvider().loadTags();
        for (Tag u : list) {
            Log.d(TAG, "test: "+u.getName());
        }
        Log.d(TAG, "test: "+list.size());

    }

    public void testPost () {
        Log.e(TAG, "test: ADDDDD POOOOOOST");
        for (int i=0; i<10; i++) {
            Post u = new Post(i,"Title " + i, "Description" + i, "Photo_path" + i, i, new Date(), i+10,i);
            DataProvider.getSingletone(getApplicationContext()).getPostProvider().add(u);
        }


        Log.e(TAG, "test: LOADDDD POOOOOOST");
        List<Post> list = DataProvider.getSingletone(getApplicationContext()).getPostProvider().loadPosts();
        Log.d(TAG, "test: "+list.size());
        for (Post u : list) {
            Log.d(TAG, "test: "+u);
        }

        Log.e(TAG, "test: DELETEEE POOOOOOST");
        for(int i=0; i<2; i++) {
            DataProvider.getSingletone(getApplicationContext()).getPostProvider().delete(list.get(i));
        }

        Log.e(TAG, "test: UPDATEE POOOOOOST");
        list.get(0).setTitle("Cevap");
        list.get(0).setDescription("Cevap");
        list.get(0).setPhoto_path("Cevap");
        list.get(0).setDate(new Date());
        list.get(0).setLikes(666);
        list.get(0).setDislikes(999);
        DataProvider.getSingletone(getApplicationContext()).getPostProvider().update(list.get(0));

        Log.d(TAG, "test: LOADDDD ");
        list = DataProvider.getSingletone(getApplicationContext()).getPostProvider().loadPosts();
        for (Post u : list) {
            Log.d(TAG, "test: "+u.getTitle());
            Log.d(TAG, "test: "+u.getDescription());
            Log.d(TAG, "test: "+u.getPhoto_path());
            Log.d(TAG, "test: "+u.getDate().toString());
            Log.d(TAG, "test: "+u.getLikes());
            Log.d(TAG, "test: "+u.getDislikes());
        }
        Log.d(TAG, "test: "+list.size());


    }

    public void testComment () {

        Log.e(TAG, "test: ADDDDD COOOOOOOOOOOOM");
        for (int i=0; i<10; i++) {
            Comment u = new Comment(i, "Name" + i,"Description" + i,i,new Date("dd/MM/yyyy"),i,16+i,i);
            DataProvider.getSingletone(getApplicationContext()).getCommentProvider().add(u);
            Log.e(TAG, "testComment: VREMEEEEEEEEEEEEEEEEEEEEE" + u.getDate());
        }


        Log.e(TAG, "test: LOADDDD COOOOOOOOOOOOM");
        List<Comment> list = DataProvider.getSingletone(getApplicationContext()).getCommentProvider().loadComments();
        Log.e(TAG, "test: "+list.size());
        for (Comment u : list) {
            Log.d(TAG, "test: "+u);
        }

        Log.e(TAG, "test: DELETEEE COOOOOOOOOOOOM");
        for(int i=0; i<2; i++) {
            DataProvider.getSingletone(getApplicationContext()).getCommentProvider().delete(list.get(i));
        }

        Log.d(TAG, "test: UPDATEE ");
        list.get(0).setTitle("Cevap");
        list.get(0).setDescription("Cevap");
        list.get(0).setDate(new Date());
        list.get(0).setLikes(666);
        list.get(0).setDislikes(999);
        DataProvider.getSingletone(getApplicationContext()).getCommentProvider().update(list.get(0));

        Log.e(TAG, "test: LOADDDD COOOOOOOOOOOOM");
        list = DataProvider.getSingletone(getApplicationContext()).getCommentProvider().loadComments();
        for (Comment u : list) {
            Log.d(TAG, "test: "+u.getTitle());
            Log.d(TAG, "test: "+u.getDescription());
            Log.d(TAG, "test: "+u.getDate().toString());
            Log.d(TAG, "test: "+u.getLikes());
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
