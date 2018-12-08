package com.example.andrewmalygin.androiddp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.example.andrewmalygin.androiddp.MainWindow.MainFragment;

public class NavActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private FragmentTransaction fragt;
    private MainFragment mainFragment = new MainFragment();
    private MyCoursesFragment myCourseFragment = new MyCoursesFragment();

    private void commit(int id){
        fragt = getSupportFragmentManager().beginTransaction();

        switch (id){
            case R.id.nav_main:
                fragt.replace(R.id.content_frame, mainFragment);
                break;
            case R.id.nav_mycourse:
                fragt.replace(R.id.content_frame, myCourseFragment);
                break;
        }

        fragt.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);



        fragt = getSupportFragmentManager().beginTransaction();
        fragt.replace(R.id.content_frame, mainFragment);
        fragt.commit();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                menuItem.setChecked(true);

                drawerLayout.closeDrawers();


                commit(menuItem.getItemId());

                return true;
            }
        });

    }

}
