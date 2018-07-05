package com.example.kanokk.myapplication;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;


import com.example.kanokk.myapplication.Handling.CallbackWrapper;
import com.example.kanokk.myapplication.model.BookModel;
import com.example.kanokk.myapplication.page.PageFragment;
import com.example.kanokk.myapplication.page2.Page2Fragment;
import com.example.kanokk.myapplication.pagealldata.AllDataFragment;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity implements PageFragment.Listener {

    private Button clk_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PageFragment oneFragment = PageFragment.newInstance("");
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, oneFragment)
                .commit();
    }


    @Override
    public void onNextPage(BookModel model) {
        Toast.makeText(getApplicationContext(),"Data : "+model.getId(),Toast.LENGTH_LONG).show();
        Page2Fragment twoFragment = Page2Fragment.newInstance(model);
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, twoFragment)
                .commit();
    }

    @Override
    public void onAllDataPage() {
        AllDataFragment allFragment = AllDataFragment.newInstance();
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, allFragment)
                .commit();
    }
}