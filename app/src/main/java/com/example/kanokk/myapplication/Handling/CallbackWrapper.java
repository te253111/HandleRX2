package com.example.kanokk.myapplication.Handling;
import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import java.io.IOException;
import java.net.SocketTimeoutException;

import io.reactivex.observers.DisposableObserver;
import okhttp3.ResponseBody;

public abstract class CallbackWrapper<T> extends DisposableObserver<T> {
    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof HttpException) {
            ResponseBody responseBody = ((HttpException)e).response().errorBody();
            Log.e("error","HttpException");
        } else if (e instanceof SocketTimeoutException) {
            Log.e("error","SocketTimeoutException");
        } else if (e instanceof IOException) {
            Log.e("error","IOException");
        } else {
            Log.e("error",e.getMessage());
        }
    }

    @Override
    public void onComplete() {

    }
}
