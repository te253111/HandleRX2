package com.example.kanokk.myapplication.page2;

import com.example.kanokk.myapplication.model.BookModel;

public interface Page2Contract {
    interface View {
        void ShowData(BookModel model);
    }

    interface Presenter {
        void prepareData(BookModel model);
        void addview(View view);
    }
}
