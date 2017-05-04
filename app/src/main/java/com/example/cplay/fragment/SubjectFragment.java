package com.example.cplay.fragment;

import android.view.View;

import com.example.cplay.view.LoadingPage;

/**
 * Created by CRZ on 2017/5/4 11:31.
 * SubjectFragment
 */

public class SubjectFragment extends BaseFragment {
    @Override
    protected LoadingPage.LoadResult load() {
        return LoadingPage.LoadResult.error;
    }

    @Override
    protected View createSuccessView() {
        return null;
    }
}
