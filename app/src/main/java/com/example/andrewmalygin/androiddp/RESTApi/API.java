package com.example.andrewmalygin.androiddp.RESTApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    @GET()
    Call<List<Category>> getCategories();

}
