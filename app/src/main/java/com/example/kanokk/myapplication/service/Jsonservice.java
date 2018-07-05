package com.example.kanokk.myapplication.service;

import com.example.kanokk.myapplication.model.BookModel;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface Jsonservice {
    @GET("posts/{id}")
    Observable<BookModel> getBooks(@Path("id") String id);

    @GET("posts")
    Observable<List<BookModel>> getAllBooks();
}
