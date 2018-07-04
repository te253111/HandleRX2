package com.example.kanokk.myapplication.page;

public interface PageContract {
    interface View {
        void setMessageBody(String body);
    }

    interface Presenter {
        void prepareData();

        void addview(View view);
    }
}
