package com.zsy.sample;

import java.util.Arrays;
import java.util.List;

import mzs.lib.test.TestActivity;
import zsy.base.android.wrapper.log.AndroidPrinter;
import zsy.base.java.wrapper.log.AssembleLogAdapter;
import zsy.base.java.wrapper.log.Lg;
import zsy.base.java.wrapper.log.LogFormat;

public class MainActivity extends TestActivity {


    @Override
    public List<String> getActions() {
        return Arrays.asList("Test", "");
    }

    @Override
    public void init() {
        super.init();
        Lg.setLogAdapter(new AssembleLogAdapter(
                new LogFormat.Builder()
                        .setPrinter(new AndroidPrinter())
                        .build()));
    }

    @Override
    public void onItemClick(int position) {
        switch (position) {
            case 0:
                Lg.i("hello");
                break;
        }
    }
}
