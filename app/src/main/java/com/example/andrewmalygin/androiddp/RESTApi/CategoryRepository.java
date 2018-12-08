package com.example.andrewmalygin.androiddp.RESTApi;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryRepository {

    private Api api;
    private OnCategoryRepositoryChange onCategoryRepositoryChange;

    public void setOnCategoryRepositoryChange(OnCategoryRepositoryChange onCategoryRepositoryChange) {
        this.onCategoryRepositoryChange = onCategoryRepositoryChange;
    }

    public CategoryRepository(Api api){
        this.api = api;
    }

    public void loadCategory(){

        final List<Category> list = new ArrayList<>();
        api.getCategories().enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {

                if(response.body() != null) list.addAll(response.body());
                onCategoryRepositoryChange.categotyLoaded(list);
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {

            }
        });
    }
}
