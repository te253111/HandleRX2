package com.example.kanokk.myapplication.page;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.kanokk.myapplication.R;
import com.example.kanokk.myapplication.model.BookModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class PageFragment extends Fragment implements PageContract.View {
    private static final String ARG_PARAM1 = "param1";

    PagePresenter presenter = new PagePresenter();

    Listener listener;
    @BindView(R.id.click_btn)
    Button clickBtn;
    Unbinder unbinder;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public interface Listener {
        void onNextPage(BookModel model);
    }

    private String mParam1;

    public PageFragment() {

    }

    public static PageFragment newInstance(String param1) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.addview(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (Listener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void setMessageBody(String body) {
        Log.d("Book :", body);
    }

    @Override
    public void onNextPage(BookModel model) {
        listener.onNextPage(model);
    }

    @OnClick(R.id.click_btn)
    public void  Click(){
        presenter.prepareData();
    }
}
