package com.zsy.sample;

import android.widget.TextView;

import butterknife.BindView;
import mzs.lib.app.BaseFragment;

public class HomeFragment2 extends BaseFragment {


    @BindView(R.id.tv) TextView tv;

    public static HomeFragment2 newInstance() {
        return new HomeFragment2();
    }

    @Override
    public void initContentView() {
        setContentView(R.layout.fragment_home);
    }

    @Override
    public void initView() {
        super.initView();
        tv.setText("home2");
    }
}
