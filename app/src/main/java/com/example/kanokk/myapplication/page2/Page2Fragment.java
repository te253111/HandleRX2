package com.example.kanokk.myapplication.page2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kanokk.myapplication.R;
import com.example.kanokk.myapplication.model.BookModel;

public class Page2Fragment extends Fragment implements Page2Contract.View {
    private static final String ARG_PARAM1 = "param1";

    private BookModel mParam1;
    TextView txt1;
    TextView txt2;


    Page2Presenter presenter = new Page2Presenter();

    public Page2Fragment() {

    }

    public static Page2Fragment newInstance(BookModel param1) {
        Page2Fragment fragment = new Page2Fragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getParcelable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_page2, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txt1 = view.findViewById(R.id.txt1);
        txt2 = view.findViewById(R.id.txt2);

        presenter.addview(this);
        presenter.prepareData(mParam1);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void ShowData(BookModel model) {
        txt1.setText(model.getId());
        txt2.setText(model.getTitle());
    }
}
