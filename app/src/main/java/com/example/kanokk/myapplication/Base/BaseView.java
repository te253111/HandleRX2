package com.example.kanokk.myapplication.Base;

public interface BaseView<T> {
    void addview(T t);
    void onPause();
    void onResume();
}
