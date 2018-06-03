package com.example.karl.notron.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.karl.notron.R;
import com.example.karl.notron.adapters.DrawerListAdapter;
import com.example.karl.notron.adapters.PostAdapter;
import com.example.karl.notron.model.NavItem;
import com.example.karl.notron.model.Post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostsActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ArrayList<NavItem> mNavItems = new ArrayList<NavItem>();
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private RelativeLayout mDrawerPane;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private SharedPreferences sharedPreferences;
    private ListView listView;


    private Post post = new Post();
    private Post post1 = new Post();
    private PostAdapter postAdapter;
    private List<Post> posts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        mTitle = mDrawerTitle = getTitle();
        mDrawerLayout = findViewById(R.id.drawerLayout);
        mDrawerList = findViewById(R.id.navList);

        // Populate the Navigtion Drawer with options
        mDrawerPane = findViewById(R.id.drawerPane);
        DrawerListAdapter adapter = new DrawerListAdapter(this, mNavItems);
        mDrawerList.setOnItemClickListener(new PostsActivity.DrawerItemClickListener());
        mDrawerList.setAdapter(adapter);

        mDrawerLayout = findViewById(R.id.drawerLayout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.posts_toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp); //nadji beo
            actionBar.setHomeButtonEnabled(true);
        }

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);

        initializePostsObj();

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        //nzm sta radi ova linija ispod
        mDrawerToggle.syncState();

        postAdapter = new PostAdapter(PostsActivity.this,posts);
        listView = findViewById(R.id.post_list);
        listView.setAdapter(postAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                post = posts.get(position);
                Intent i = new Intent(PostsActivity.this, ReadPostActivity.class);
                i.putExtra("Post", post.getId());
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_bar,menu);
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
                if (mDrawerLayout.isDrawerOpen(mDrawerPane)) {
                    mDrawerLayout.closeDrawers();
                } else {
                    mDrawerLayout.openDrawer(GravityCompat.START);
                }
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItemFromDrawer(position);
        }
    }

    private void selectItemFromDrawer(int position) {
        if(position == 0){
//            FragmentTransition.to(MyFragment.newInstance(), this, false);
            Intent preference = new Intent(this, PostsActivity.class);
            startActivity(preference);
        }else if(position == 1){
            Intent preference = new Intent(this, CreatePostActivity.class);
//            Intent preference = new Intent(this, PostsActivity.class);
            startActivity(preference);
        }else if(position == 2){
            Intent preference = new Intent(this, SettingsActivity.class);
//            Intent preference = new Intent(this, CreatePostActivity.class);
            startActivity(preference);
        }else if(position == 3){
//            Intent preference = new Intent(this, SettingsActivity.class);
//            startActivity(preference);
        }else if(position == 4){
            //..
        }else{
            Log.e("DRAWER", "Nesto van opsega!");
        }

        mDrawerList.setItemChecked(position, true);
//        if(position != 5) // za sve osim za sync
//        {
//            setTitle(mNavItems.get(position).getmTitle());
//        }
        setTitle(mNavItems.get(position).getmTitle());
        mDrawerLayout.closeDrawer(mDrawerPane);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    private void prepareMenu(ArrayList<NavItem> mNavItems ){
        mNavItems.add(new NavItem(getString(R.string.home), getString(R.string.home_long), R.drawable.ic_home_black_24dp));
        mNavItems.add(new NavItem(getString(R.string.create), getString(R.string.create_long), R.drawable.ic_add_black_24dp));
        mNavItems.add(new NavItem(getString(R.string.settings), getString(R.string.settings_long), R.drawable.ic_settings_black_24dp));
        mNavItems.add(new NavItem(getString(R.string.about), getString(R.string.about_long), R.drawable.ic_menu_black_24dp));
    }

    public void btnLogout(View view){
        sharedPreferences = getSharedPreferences("Login", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

    private void initializePostsObj() {
        post.setDate(new Date(2018-1900, 1, 1, 10, 10));
        post.setDescription("At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias exceptur");
        post.setTitle("Naslov");
        post.setLikes(3);

        post1.setDate(new Date(2018-1900, 2, 1, 10, 10));
        post1.setTitle("Naslov2");
        post1.setDescription("At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi");
        post1.setLikes(22);

        posts.add(post);
        posts.add(post1);
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
    protected void onResume() {
        super.onResume();
//        napravi neku funkiciju koja ce da pogleda sta je sa podesavanjima
        postAdapter.notifyDataSetChanged();
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
