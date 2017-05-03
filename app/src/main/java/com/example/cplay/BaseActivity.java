package com.example.cplay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by 润泽 on 2017/5/3.
 * Base
 */

public class BaseActivity extends AppCompatActivity {
    // 管理运行的所有的activity 增删快
    public final static List<BaseActivity> mActivities = new LinkedList<>();

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        synchronized (mActivities) {
            mActivities.add(this);
        }

        init();
        initView();
        initToolBar();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        synchronized (mActivities) {
            mActivities.remove(this);
        }
    }

    public void killAll() {
        // 复制了一份mActivities 集合
        List<BaseActivity> copy;
        synchronized (mActivities) {
            copy = new LinkedList<>(mActivities);
        }
        for (BaseActivity activity : copy) {
            activity.finish();
        }
        // 杀死当前的进程
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    protected void init() {
    }

    protected void initView() {
    }

    protected void initToolBar() {

    }
}
