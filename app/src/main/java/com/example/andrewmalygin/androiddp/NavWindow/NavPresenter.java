package com.example.andrewmalygin.androiddp.NavWindow;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.example.andrewmalygin.androiddp.CourseWindow.CourseActivity;
import com.example.andrewmalygin.androiddp.MainWindow.MainFragment;
import com.example.andrewmalygin.androiddp.MainWindow.OnMainFragmentChanged;
import com.example.andrewmalygin.androiddp.MyCourseWindow.MyCoursesFragment;
import com.example.andrewmalygin.androiddp.R;

public class NavPresenter {

    private NavActivity activity;
    private FragmentTransaction ft;
    private MainFragment mainFragment;
    private MyCoursesFragment myCoursesFragment;


    public NavPresenter(final NavActivity activity){
        this.activity = activity;

        mainFragment = new MainFragment();
        myCoursesFragment = new MyCoursesFragment();

        mainFragment.setOnMainFragmentChanged(new OnMainFragmentChanged() {
            @Override
            public void onCourseClick() {
                Intent intent = new Intent(activity, CourseActivity.class);
                Log.i("DEB", "kek");
                activity.startActivity(intent);
            }
        });

        setFragment(mainFragment);
    }

    public void setFragment(Fragment f){
        ft = activity.getSupportFragmentManager().beginTransaction();

        ft.replace(R.id.content_frame, f);
        ft.commit();
    }

    public void setFragment(int id){
        ft = activity.getSupportFragmentManager().beginTransaction();
        switch (id){
            case R.id.nav_main:
                ft.replace(R.id.content_frame, mainFragment);
                activity.setTitle("Популярные курсы");
                break;
            case R.id.nav_mycourse:
                ft.replace(R.id.content_frame, myCoursesFragment);
                activity.setTitle("Мои курсы");
                break;
        }

        ft.commit();
    }

}
