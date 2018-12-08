package com.example.andrewmalygin.androiddp;

import android.app.Application;

import com.example.andrewmalygin.androiddp.RESTApi.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main extends Application {

    private static API api;

    @Override
    public void onCreate() {
        super.onCreate();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("192.168.0.75:8000").addConverterFactory(GsonConverterFactory.create()).build();

        api = retrofit.create(API.class);

    }

    public static API getApi(){
        return api;
    }
}
