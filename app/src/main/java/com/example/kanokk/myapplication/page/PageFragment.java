package com.example.kanokk.myapplication.page;

import android.content.Context;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.kanokk.myapplication.MainActivity;
import com.example.kanokk.myapplication.R;
import com.example.kanokk.myapplication.model.BookModel;

public class PageFragment extends Fragment implements PageContract.View {
    private static final String ARG_PARAM1 = "param1";

    PagePresenter presenter = new PagePresenter();

    Button btn;

    Listener listener;

    public interface Listener{
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
        return inflater.inflate(R.layout.fragment_page, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.addview(this);

        btn = view.findViewById(R.id.click_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.prepareData();
            }
        });
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
        Log.d("Book :",body);
    }

    @Override
    public void onNextPage(BookModel model) {
        listener.onNextPage(model);
    }
}
