package com.zsy.sample;

import android.widget.TextView;

import butterknife.BindView;
import mzs.lib.app.BaseFragment;

public class MineFragment extends BaseFragment {


    @BindView(R.id.tv) TextView tv;

    public static MineFragment newInstance() {
        return new MineFragment();
    }

    @Override
    public void initContentView() {
        setContentView(R.layout.fragment_home);
    }

    @Override
    public void initView() {
        super.initView();
        tv.setText("mine");
    }
}
