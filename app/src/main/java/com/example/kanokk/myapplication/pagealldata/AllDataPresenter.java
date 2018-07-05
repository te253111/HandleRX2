package com.example.kanokk.myapplication.pagealldata;

import com.example.kanokk.myapplication.Handling.CallbackWrapper;
import com.example.kanokk.myapplication.RestService;
import com.example.kanokk.myapplication.model.BookModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AllDataPresenter implements AllDataContract.Presenter {
    private AllDataContract.View view;

    @Override
    public void prepareData() {
        Observable<List<BookModel>> bookservice = RestService.getInstance().getJsonservice().getAllBooks();

        bookservice.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new Bookobserver());
    }

    @Override
    public void addview(AllDataContract.View view) {
        this.view = view;
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    private class Bookobserver extends CallbackWrapper<List<BookModel>> {
        @Override
        public void onNext(List<BookModel> bookModels) {
            view.setItems(bookModels);
        }

        @Override
        public void onComplete() {

        }
    }
}
