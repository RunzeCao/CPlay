package com.example.cplay.fragment;

import android.view.View;
import android.widget.TextView;

import com.example.cplay.view.LoadingPage;

/**
 * Created by CRZ on 2017/5/4 11:33.
 * TopFragment
 */

class TopFragment extends BaseFragment {
    @Override
    protected LoadingPage.LoadResult load() {
        return LoadingPage.LoadResult.empty;
    }

    @Override
    protected View createSuccessView() {
        TextView view=new TextView(getActivity());
        view.setText("TopFragment");
        return view;
    }
}
