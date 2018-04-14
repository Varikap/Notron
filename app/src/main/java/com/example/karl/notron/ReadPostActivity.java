package com.example.karl.notron;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ReadPostActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_post);

        Toolbar toolbar = (Toolbar) findViewById(R.id.include);
        toolbar.setTitle("Posts");
        setSupportActionBar(toolbar);


        mDrawer = findViewById(R.id.drawer_layout);
        NavigationView navView = findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        item.setChecked(true);
                        switch (item.getItemId()){
                            case R.id.create_post_drawer:
                                startActivity(new Intent(ReadPostActivity.this, CreatePostActivity.class));
                                break;
                            case R.id.settings_drawer:
                                startActivity(new Intent(ReadPostActivity.this, SettingsActivity.class));
                                break;
                        }
                        mDrawer.closeDrawers();
                        return true;
                    }
                }
        );

        ActionBar  actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuinfl = getMenuInflater();
        menuinfl.inflate(R.menu.app_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action_new_post:
                Intent i = new Intent(this,CreatePostActivity.class);
                startActivity(i);
                break;

            case R.id.action_settings:
                Intent j = new Intent(this,SettingsActivity.class);
                startActivity(j);
                break;

            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                break;

            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

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
