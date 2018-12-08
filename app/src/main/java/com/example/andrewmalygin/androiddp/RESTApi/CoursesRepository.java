package com.example.andrewmalygin.androiddp.RESTApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoursesRepository {

    private Api api;
    private OnCoursesRepositoryChange onCoursesRepositoryChange;

    public void setOnCoursesRepositoryChange(OnCoursesRepositoryChange onCoursesRepositoryChange) {
        this.onCoursesRepositoryChange = onCoursesRepositoryChange;
    }

    public CoursesRepository(Api api){
        this.api = api;
    }

    public void loadCourses(){
        final List<Course> res = new ArrayList<>();
        api.getCourses().enqueue(new Callback<List<Course>>() {
            @Override
            public void onResponse(Call<List<Course>> call, Response<List<Course>> response) {
                if(response.body() != null) res.addAll(response.body());
                onCoursesRepositoryChange.coursesLoaded(res);
            }

            @Override
            public void onFailure(Call<List<Course>> call, Throwable t) {

            }
        });
    }
}
