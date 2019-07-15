package com.zsy.sample;

import java.util.Arrays;
import java.util.List;

import mzs.lib.test.TestActivity;
import zsy.base.lg.android.AndroidLogAdapter;
import zsy.base.lg.android.AndroidPrinter;
import zsy.base.lg.java.AssembleLogAdapter;
import zsy.base.lg.java.Lg;
import zsy.base.lg.java.LogFormat;
import zsy.base.lg.java.SystemLogAdapter;


public class MainActivity extends TestActivity {


    @Override
    public List<String> getActions() {
        return Arrays.asList("javaPrint", "AndroidLog", "isLoggable");
    }

    @Override
    public void init() {
        super.init();


    }

    @Override
    public void onItemClick(int position) {
        switch (position) {
            case 0:
                Lg.setLogAdapter(new AssembleLogAdapter(
                        new LogFormat.Builder()
                                .setBaseTag("Lg")
                                .setShowDesInfo(true)
//                        .setMinLevel(DEBUG)
                                .setMethodOffset(4)
                                .setShowMethodTrace(true)
                                .build()));
                Lg.w("jj", "hello");
                Lg.v("jj", "world");
                Lg.setLogAdapter(new SystemLogAdapter());
                Lg.w("jj", "hello");
                Lg.v("jj", "world");


                break;
            case 1:
                Lg.setLogAdapter(new AssembleLogAdapter(
                        new LogFormat.Builder()
                                .setBaseTag("Lg")
                                .setShowDesInfo(true)
//                        .setMinLevel(DEBUG)
                                .setPrinter(AndroidPrinter.INSTANCE)
                                .setMethodOffset(4)
                                .setShowMethodTrace(true)
                                .build()));
                Lg.e("jj", "hello");
                Lg.v("jj", "world");
                Lg.setLogAdapter(new AndroidLogAdapter());
                Lg.e("jj", "hello");
                Lg.v("jj", "world");
                break;
            case 2:
                Lg.v("v", "vvvvv");
                Lg.d("d", "DDDDD");
                Lg.i("i", "iiiii");
                Lg.w("w", "wwwww");
                Lg.e("e", "eeeee");
                Lg.i( "emp");
                Lg.setLogAdapter(new AndroidLogAdapter());
                Lg.v("v", "vvvvv");
                Lg.d("d", "DDDDD");
                Lg.i("i", "iiiii");
                Lg.w("w", "wwwww");
                Lg.e("e", "eeeee");
                break;
        }
    }

//    private void test() {
//        String[] arr1 = new String[]{"111111", "22222"};
//        String[] arr2 = new String[]{"333333", "444444"};
//        String[] arr3 = new String[]{"555555", "666666"};
//        Lg.i("String", Arrays.toString(concat(arr1, arr2, arr3)));
//        long startMs = System.currentTimeMillis();
//        for (int i = 0; i < 100000; i++) {
//            concat(arr1, arr2, arr3);
//        }
//        long endMs = System.currentTimeMillis();
//        Lg.i("disMs1:" + (endMs - startMs));
//    }
//
//    public <T> T[] ct(T[]... src) {
//        VerifyUtils.requireNonNull(src, "params is null");
//        if (src.length == 1) {
//            return src[0];
//        }
//        int totalLen = 0;
//        for (T[] e : src) {
//            if (e == null) {
//                continue;
//            }
//            totalLen += e.length;
//        }
//        T[] des = (T[]) new Object[totalLen];
//        int currentLen = 0;
//        for (T[] object : src) {
//            if (object == null) {
//                continue;
//            }
//            System.arraycopy(object, 0, des, currentLen, object.length);
//            currentLen += object.length;
//        }
//        return des;
//    }
}
