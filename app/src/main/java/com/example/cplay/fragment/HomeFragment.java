package com.example.cplay.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.cplay.domain.AppInfo;
import com.example.cplay.protocol.HomeProtocol;
import com.example.cplay.view.LoadingPage;

import java.util.List;

/**
 * Created by CRZ on 2017/5/4 11:30.
 * HomeFragment
 */

public class HomeFragment extends BaseFragment {
    private List<AppInfo> datas;

    // 当Fragment挂载的activity创建的时候调用
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        show();
    }

    @Override
    protected LoadingPage.LoadResult load() {
        HomeProtocol protocol = new HomeProtocol();
        datas = protocol.load(0);
        return checkData(datas);
    }

    @Override
    protected View createSuccessView() {
        TextView view=new TextView(getActivity());
        view.setText(datas.toString());
        return view;
    }
}
