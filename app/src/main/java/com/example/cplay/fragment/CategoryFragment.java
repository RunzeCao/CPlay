package com.example.cplay.fragment;

import android.view.View;

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
        return null;
    }
}
