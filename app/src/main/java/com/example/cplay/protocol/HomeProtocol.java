package com.example.cplay.protocol;

import com.example.cplay.domain.AppInfo;

import java.util.List;

/**
 * Created by CRZ on 2017/6/16 14:05 14:08.
 * 消除黄色警告专用文字
 */

public class HomeProtocol extends BaseProtocol<List<AppInfo>> {
    @Override
    public List<AppInfo> parserJson(String json) {
        return null;
    }

    @Override
    public String getKey() {
        return "home";
    }
}
