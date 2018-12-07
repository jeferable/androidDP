package com.example.andrewmalygin.androiddp;

import com.example.andrewmalygin.androiddp.RESTApi.Course;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter {

    private List<Course> courses;
    private MainActivity activity;

    public MainPresenter(MainActivity activity){
        this.activity = activity;

        courses = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            courses.add(new Course());
        }

    }

    public List<Course> getCourses(){
        return courses;
    }

}
