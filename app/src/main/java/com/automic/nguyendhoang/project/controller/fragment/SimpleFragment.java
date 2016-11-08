package com.automic.nguyendhoang.project.controller.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.automic.nguyendhoang.project.R;
import com.automic.nguyendhoang.project.common.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleFragment extends Fragment {

    private Unbinder mUnbinder;

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    public SimpleFragment() {
        // Required empty public constructor
    }

    public static SimpleFragment newInstance(String title) {
        Bundle args = new Bundle();
        args.putString(Constant.TITLE_ARGUMENT, title);
        SimpleFragment fragment = new SimpleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simple, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String title = getArguments().getString(Constant.TITLE_ARGUMENT);
        tvTitle.setText(title);
//        tvTitle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                EventBus.getDefault().post(new TitleEvent("ninja"));
//            }
//        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
