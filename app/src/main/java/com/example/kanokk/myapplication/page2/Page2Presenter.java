package com.example.kanokk.myapplication.page2;

import com.example.kanokk.myapplication.model.BookModel;

public class Page2Presenter implements Page2Contract.Presenter {

    private Page2Contract.View view;

    @Override
    public void prepareData(BookModel model) {
        view.ShowData(model);
    }

    @Override
    public void addview(Page2Contract.View view) {
        this.view = view;
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }
}
