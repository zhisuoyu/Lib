package com.zsy.sample;

import android.widget.TextView;

import butterknife.BindView;
import mzs.lib.app.BaseFragment;

public class HomeFragment extends BaseFragment {


    @BindView(R.id.tv) TextView tv;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void initContentView() {
        setContentView(R.layout.fragment_home);
    }

    @Override
    public void initView() {
        super.initView();
        tv.setText("home");
    }
}
