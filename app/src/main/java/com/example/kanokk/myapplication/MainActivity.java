package com.example.kanokk.myapplication;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;


import com.example.kanokk.myapplication.Handling.CallbackWrapper;
import com.example.kanokk.myapplication.model.BookModel;
import com.example.kanokk.myapplication.page.PageFragment;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    private Button clk_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PageFragment oneFragment = PageFragment.newInstance("");
        getFragmentManager().beginTransaction()
                .add(R.id.fragment_container, oneFragment)
                .commit();
    }
}