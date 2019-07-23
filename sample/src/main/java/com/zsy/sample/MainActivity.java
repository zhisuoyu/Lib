package com.zsy.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

import mzs.lib.test.TestActivity;


public class MainActivity extends TestActivity {


    @Override
    public List<String> getActions() {
        return Arrays.asList("DgAct", "MainAct");
    }

    @Override
    public void onItemClick(int position) {
        switch (position) {
            case 0:
                startAct(DgAct.class);
                break;
            case 1:
                startAct(MainAct.class);
                break;
        }
    }

    private void startAct(Class<? extends AppCompatActivity> cls) {
        startActivity(new Intent(this, cls));
    }

}
