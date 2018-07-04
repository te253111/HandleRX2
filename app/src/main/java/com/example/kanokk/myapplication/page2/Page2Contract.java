package com.example.kanokk.myapplication.page2;

import com.example.kanokk.myapplication.Base.BaseView;
import com.example.kanokk.myapplication.model.BookModel;

public interface Page2Contract {
    interface View {
        void ShowData(BookModel model);
    }

    interface Presenter extends BaseView<Page2Contract.View> {
        void prepareData(BookModel model);
    }
}
