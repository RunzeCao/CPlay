package com.example.cplay.fragment;

import android.util.SparseArray;

/**
 * Created by CRZ on 2017/5/4 11:19.
 * Fragment工厂类 使用SparseArray代替HashMap
 */

public class FragmentFactory {
    private static SparseArray<BaseFragment> mFragments = new SparseArray<>();

    public static BaseFragment createFragment(int position) {
        BaseFragment fragment = null;
        if (mFragments.get(position) != null) {
            fragment = mFragments.get(position);  //在集合中取出来Fragment
        } else {
            if (position == 0) {
                fragment = new HomeFragment();
            } else if (position == 1) {
                fragment = new AppFragment();
            } else if (position == 2) {
                fragment = new GameFragment();
            } else if (position == 3) {
                fragment = new SubjectFragment();
            } else if (position == 4) {
                fragment = new CategoryFragment();
            } else if (position == 5) {
                fragment = new TopFragment();
            }
            if (fragment != null) {
                mFragments.put(position, fragment);
            }
        }
        return fragment;
    }
}
