package com.ken.quizapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ken.quizapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {


    private String title;
    private TextView tvTitle;

    public QuestionFragment(String title) {
        this.title = title;
    }

    public QuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_question, container, false);

        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        tvTitle.setText(title);

        return view;
    }

}
