package com.example.andrewmalygin.androiddp.RESTApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("get/categories")
    Call< List<Category> > getCategories();

}
