package com.example.kanokk.myapplication.page;

import android.util.Log;

import com.example.kanokk.myapplication.Handling.CallbackWrapper;
import com.example.kanokk.myapplication.RestService;
import com.example.kanokk.myapplication.model.BookModel;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PagePresenter implements PageContract.Presenter{

    private PageContract.View view;

    @Override
    public void prepareData() {
        Observable<BookModel> bookservice = RestService.getInstance().getJsonservice().getBooks("1");

        bookservice.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new Bookobserver());
    }

    @Override
    public void addview(PageContract.View view) {
        this.view = view;
    }

    private class Bookobserver extends CallbackWrapper<BookModel> {
        @Override
        public void onNext(BookModel bookModel) {
            Log.d("Book :",bookModel.getId());
            Log.d("Book : title",bookModel.getTitle());
            view.onNextPage(bookModel);
        }

        @Override
        public void onComplete() {
            view.setMessageBody("complete");
        }
    }
}
