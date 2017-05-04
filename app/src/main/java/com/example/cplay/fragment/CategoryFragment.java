package com.example.cplay.fragment;

import android.view.View;
import android.widget.TextView;

import com.example.cplay.view.LoadingPage;

/**
 * Created by CRZ on 2017/5/4 11:32.
 * CategoryFragment
 */

class CategoryFragment extends BaseFragment {
    @Override
    protected LoadingPage.LoadResult load() {
        return LoadingPage.LoadResult.error;
    }

    @Override
    protected View createSuccessView() {
        TextView view=new TextView(getActivity());
        view.setText("CategoryFragment");
        return view;
    }
}
