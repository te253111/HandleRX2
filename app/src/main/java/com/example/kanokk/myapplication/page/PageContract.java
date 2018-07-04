package com.example.kanokk.myapplication.page;

import com.example.kanokk.myapplication.Base.BaseView;
import com.example.kanokk.myapplication.model.BookModel;

public interface PageContract {
    interface View {
        void setMessageBody(String body);
        void onNextPage(BookModel model);
    }

    interface Presenter extends BaseView<PageContract.View> {
        void prepareData();
    }
}
