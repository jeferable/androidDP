package com.example.andrewmalygin.androiddp;

import android.app.Application;
import android.util.Log;

import com.example.andrewmalygin.androiddp.RESTApi.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main extends Application {

    private static Api api;
    private Retrofit retrofit;


    @Override
    public void onCreate() {
        super.onCreate();
        retrofit = new Retrofit.Builder().baseUrl("http://192.168.0.75:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(Api.class);
        if(api == null) Log.i("DEBUG", "NOOO");
    }

    public static Api getApi(){
        return api;
    }
}
