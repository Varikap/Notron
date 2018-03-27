package com.example.karl.notron;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class PostsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        Button btnSettings = (Button) findViewById(R.id.buttonSettings);
        Button btnReadPost = (Button) findViewById(R.id.buttonReadPost);
        Button btnCreatePost = (Button) findViewById(R.id.buttonCreatePost);
        btnCreatePost.setOnClickListener(createListener);
        btnReadPost.setOnClickListener(readListener);
        btnSettings.setOnClickListener(settingsListener);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.posts_toolbar);
        setSupportActionBar(myToolbar);

    }

    View.OnClickListener settingsListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i  = new Intent(PostsActivity.this, SettingsActivity.class);
            startActivity(i);
        }
    };
    View.OnClickListener createListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i  = new Intent(PostsActivity.this, CreatePostActivity.class);
            startActivity(i);
        }
    };
    View.OnClickListener readListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i  = new Intent(PostsActivity.this, ReadPostActivity.class);
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
