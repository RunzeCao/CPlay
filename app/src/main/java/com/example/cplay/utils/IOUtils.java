package com.example.cplay.utils;

import android.database.Cursor;

import java.io.Closeable;


public class IOUtils {
    private IOUtils() {
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable ignored) {
                ;
            }
        }

    }

    public static void closeQuietly(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable ignored) {
                ;
            }
        }

    }
}
