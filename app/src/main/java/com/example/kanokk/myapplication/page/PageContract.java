package com.example.kanokk.myapplication.page;

import com.example.kanokk.myapplication.model.BookModel;

public interface PageContract {
    interface View {
        void setMessageBody(String body);
        void onNextPage(BookModel model);
    }

    interface Presenter {
        void prepareData();
        void addview(View view);
    }
}
