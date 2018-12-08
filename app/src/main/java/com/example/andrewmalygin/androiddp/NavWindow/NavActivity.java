package com.example.andrewmalygin.androiddp.NavWindow;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.andrewmalygin.androiddp.MainWindow.MainFragment;
import com.example.andrewmalygin.androiddp.MyCourseWindow.MyCoursesFragment;
import com.example.andrewmalygin.androiddp.R;

public class NavActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private NavPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

        presenter = new NavPresenter(this);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        navigationView.getMenu().getItem(0).setChecked(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                menuItem.setChecked(true);

                drawerLayout.closeDrawers();

                presenter.setFragment(menuItem.getItemId());

                return true;
            }
        });

    }

    public Menu getMenu(){
        return navigationView.getMenu();
    }
}
