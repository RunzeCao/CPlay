package com.example.cplay.protocol;

import com.example.cplay.utils.FileUtils;
import com.example.cplay.utils.IOUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.StringWriter;

/**
 * Created by CRZ on 2017/6/8 11:08.
 *
 */

public abstract class BaseProtocol<T> {
    public T load(int index) {
        // 加载本地数据
        String json = loadLocal(index);
        if (json == null) {
            // 请求服务器
            json = loadServer(index);
            if (json != null) {
                saveLocal(json, index);
            }
        }
        if (json != null) {
            return paserJson(json);
        } else {
            return null;
        }
    }


    private void saveLocal(String json, int index) {
        BufferedWriter bw = null;
        try {
            File dir=FileUtils.getCacheDir();
            //在第一行写一个过期时间
            File file = new File(dir, getKey()+"_" + index); // /mnt/sdcard/googlePlay/cache/home_0
            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write(System.currentTimeMillis() + 1000 * 100 + "");
            bw.newLine();// 换行
            bw.write(json);// 把整个json文件保存起来
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            IOUtils.closeQuietly(bw);
        }
    }


    private String loadServer(int index) {
        return "";
    }

    private String loadLocal(int index) {
        //  如果发现文件已经过期了 就不要再去复用缓存了
        File dir = FileUtils.getCacheDir();// 获取缓存所在的文件夹
        File file = new File(dir, getKey() + "_" + index);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            long outOfDate = Long.parseLong(br.readLine());
            if (System.currentTimeMillis() > outOfDate) {
                return null;
            } else {
                String str = null;
                StringWriter sw = new StringWriter();
                while ((str = br.readLine()) != null) {

                    sw.write(str);
                }
                return sw.toString();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 解析json
     */
    public abstract T paserJson(String json);

    /**
     * 说明了关键字
     */
    public abstract String getKey();
}
