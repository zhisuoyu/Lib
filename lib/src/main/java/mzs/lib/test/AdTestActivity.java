package mzs.lib.test;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import mzs.lib.R;
import mzs.lib.app.BaseActivity;

public abstract class AdTestActivity extends BaseActivity {

    protected RecyclerView rv;
    protected AdTestRvAdapter adapter;

    @Override
    public abstract void initContentView();

    @Override
    public void initView() {
        super.initView();
        rv = findViewById(R.id.rv_ad_test);
        rv.setLayoutManager(new GridLayoutManager(this, 3));
        adapter = new AdTestRvAdapter(getDatas());
        rv.setAdapter(adapter);
        adapter.setOnItemClickLsn(new AdTestRvAdapter.OnItemClickLsn() {
            @Override
            public void onItemClick(int position) {
                AdTestActivity.this.onItemClick(position);
            }
        });
    }

    protected abstract List<RvTestEntity> getDatas();

    protected abstract void onItemClick(int position);
}
