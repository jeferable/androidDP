package com.example.andrewmalygin.androiddp.MainWindow;

import com.example.andrewmalygin.androiddp.RESTApi.Category;
import com.example.andrewmalygin.androiddp.RESTApi.Course;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter {

    private List<Course> courses;
    private List<Category> categories;
    private MainFragment activity;

    public MainPresenter(MainFragment activity){
        this.activity = activity;

        courses = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            courses.add(new Course());
        }

        categories = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            categories.add(new Category());
        }

    }

    public List<Course> getCourses(){
        return courses;
    }

    public List<Category> getCategories(){
        return categories;
    }

}
