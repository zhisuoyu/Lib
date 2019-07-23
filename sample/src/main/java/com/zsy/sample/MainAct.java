package com.zsy.sample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.yinglan.alphatabs.AlphaTabsIndicator;
import com.yinglan.alphatabs.OnTabChangedListner;

import butterknife.BindView;
import mzs.lib.app.BaseActivity;
import zsy.base.android.wrapper.nav.NavListener;
import zsy.base.lg.java.Lg;

public class MainAct extends BaseActivity {

    @BindView(R.id.vp) ViewPager vp;
    @BindView(R.id.ati) AlphaTabsIndicator ati;

    private Fragment[] fragments = new Fragment[]{HomeFragment.newInstance(), HomeFragment2.newInstance(), MineFragment.newInstance(), MineFragment2.newInstance()};


    private NavListener navListener = new NavListener() {
        @Override
        public void selectPage(int position) {
            vp.setCurrentItem(position, false);
        }

        @Override
        public void selectTab(int position) {
            ati.setTabCurrenItem(position);
        }
    };

    @Override
    public void initContentView() {
        setContentView(R.layout.act_main);
    }

    @Override
    public void initView() {
        super.initView();
        ati.setOnTabChangedListner(new OnTabChangedListner() {
            @Override
            public void onTabSelected(int tabNum) {
                Lg.i("onTabSelected:" + tabNum);
                if (ati.getTabView(tabNum).getBadgeNumber() > 0) {
                    ati.getTabView(tabNum).removeShow();
                }
                navListener.onPageSelected(tabNum);
            }
        });
        ati.getTabView(0).showNumber(12);

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments[i];
            }

            @Override
            public int getCount() {
                return 4;
            }
        });
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                navListener.onPageSelected(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }


}
