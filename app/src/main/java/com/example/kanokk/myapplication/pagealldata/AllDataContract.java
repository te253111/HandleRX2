package com.example.kanokk.myapplication.pagealldata;

import com.example.kanokk.myapplication.Base.BaseView;
import com.example.kanokk.myapplication.model.BookModel;

import java.util.List;

public interface AllDataContract {
    interface View {
        void ShowData();
        void setItems(List<BookModel> data);
    }

    interface Presenter extends BaseView<AllDataContract.View> {
        void prepareData();
    }
}
