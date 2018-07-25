package mzs.lib.app;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import butterknife.ButterKnife;
import mzs.lib.app.api.Init;
import mzs.lib.app.utils.AppState;
import mzs.lib.app.utils.AppUtils;

public abstract class BaseActivity extends AppCompatActivity implements Init {


    public final String MTAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }

        super.onCreate(savedInstanceState);
        if (AppManager.getInstance().getActivityStack().isEmpty()) {
            onFirstActivityCreate();
        }
        AppManager.getInstance().addActivity(this);
        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        AppState.getInstance().setAppRunningForeground(AppUtils.isAppOnForeground(this));
    }

    @Override
    protected void onStop() {
        super.onStop();
        AppState.getInstance().setAppRunningForeground(AppUtils.isAppOnForeground(this));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getInstance().removeActivity(this);
        if (AppManager.getInstance().getActivityStack().isEmpty()) {
            onAllActivityDestroy();
        }
    }

    private void onFirstActivityCreate() {
    }

    private void onAllActivityDestroy() {
    }


    @Override
    public void init() {
        initContentView();
        initInjector();
        initData();
        ButterKnife.bind(this);
        initView();
        initEvent();
    }


    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initInjector() {

    }

    @Override
    public void initEvent() {

    }
}
