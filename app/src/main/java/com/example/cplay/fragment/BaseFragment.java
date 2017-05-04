package com.example.cplay.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cplay.utils.ViewUtils;
import com.example.cplay.view.LoadingPage;

import java.util.List;


public abstract class BaseFragment extends Fragment {
    private LoadingPage loadingPage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (loadingPage == null) {
            loadingPage = new LoadingPage(getActivity()) {
                @Override
                public View createSuccessView() {
                    return BaseFragment.this.createSuccessView();
                }

                @Override
                protected LoadResult load() {
                    return BaseFragment.this.load();

                }
            };
        } else {
            ViewUtils.removeParent(loadingPage);
        }
        return loadingPage;
    }

    protected abstract LoadingPage.LoadResult load();

    protected abstract View createSuccessView();


    public void show() {
        if (loadingPage != null) {
            loadingPage.show();
        }
    }


    public LoadingPage.LoadResult checkData(List datas) {
        if (datas == null) {
            return LoadingPage.LoadResult.error;
        } else {
            if (datas.size() == 0) {
                return LoadingPage.LoadResult.empty;
            } else {
                return LoadingPage.LoadResult.success;
            }
        }

    }
}
