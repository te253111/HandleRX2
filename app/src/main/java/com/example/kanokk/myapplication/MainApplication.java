package com.example.kanokk.myapplication;

import android.app.Application;

import retrofit2.Retrofit;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RestService.getInstance();
    }
}
