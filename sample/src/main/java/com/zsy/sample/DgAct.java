package com.zsy.sample;

import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;

import java.util.Arrays;
import java.util.List;

import mzs.lib.test.TestActivity;
import zsy.base.android.wrapper.dialog.Dg;
import zsy.base.android.wrapper.dialog.IDg;
import zsy.base.lg.java.Lg;


public class DgAct extends TestActivity {


    @Override
    public List<String> getActions() {
        return Arrays.asList("show", "cancelDelay", "showView", "showComfirm", "showLoad");
    }
//
//    @Override
//    public void init() {
//        super.init();
//
//    }

    private Dg dg;

    Handler handler = new Handler();

    @Override
    public void initView() {
        super.initView();
        dg = new Dg(this)
                .setTitle("Title")
                .setMessage("Message")
                .setCancelable(false)
                .setIcon(getResources().getDrawable(R.mipmap.ic_launcher))
                .setPositiveButton("Positive", new IDg.OnClickListener() {
                    @Override
                    public void onClick(IDg dialog, int which) {
                        Lg.i("Positive:" + which);
                    }
                })
                .setNegativeButton("negative", new IDg.OnClickListener() {
                    @Override
                    public void onClick(IDg dialog, int which) {
                        Lg.i("negative:" + which);
                    }
                })
                .setNeutralButton("neutral", new IDg.OnClickListener() {
                    @Override
                    public void onClick(IDg dialog, int which) {
                        Lg.i("neutral:" + which);
                    }
                });
    }

    @Override
    public void onItemClick(int position) {
        switch (position) {
            case 0:
//                new Dg(this)
//                        .setTitle("TITLE")
//                        .setMessage("MESSAGE")
//                        .show();
//                CustomDialogFragment.newInstance().show(getSupportFragmentManager(), "DIALOG");
                dg.show();
                break;
            case 1:
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (dg != null) {
                            Lg.i("cancel");
                            dg.cancel();
                        }
                    }
                }, 5000);
                break;
            case 2:
//                TextView tv = new TextView(this);
//                tv.setBackgroundColor(Color.GREEN);
//                tv.setText("Hello");
                View view = LayoutInflater.from(this).inflate(R.layout.view_dialog, null);
//                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//                tv.setLayoutParams(layoutParams);
//                tv.setGravity(Gravity.CENTER);
                new Dg(this)
                        .setView(view)
                        .show();
                break;
            case 3:

                dg = Dg.showConfirmDg(this,
                        "是否确定？",
                        "Yes",
                        new IDg.OnClickListener() {
                            @Override
                            public void onClick(IDg dialog, int which) {
                                Lg.i("Yes");
                            }
                        },
                        "No",
                        new IDg.OnClickListener() {
                            @Override
                            public void onClick(IDg dialog, int which) {
                                Lg.i("No");
                            }
                        });

//                new AlertDg(this)
//                        .setMessage("是否确定？")
//                        .setPositiveButton("是", new IDg.OnClickListener() {
//                            @Override
//                            public void onClick(IDg dialog, int which) {
//                                Toast.makeText(MainActivity.this, "yes", Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .setNegativeButton("否", new IDg.OnClickListener() {
//                            @Override
//                            public void onClick(IDg dialog, int which) {
//                                Toast.makeText(MainActivity.this, "no", Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .show();
//
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (dg != null) {
//                            Lg.i("dismiss");
//                            dg.dismiss();
//                        }
//                    }
//                }, 5000);
                break;
            case 4:
                dg = Dg.showLoadDg(this, "loading", new IDg.OnKeyListener() {
                    @Override
                    public boolean onKey(IDg dialog, int keyCode, KeyEvent event) {
                        if (keyCode == KeyEvent.KEYCODE_BACK) {
                            dialog.dismiss();
                            return true;
                        }
                        return false;
                    }
                });
//                AlertDialog dialog;
//                dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
//                    @Override
//                    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
//                        return false;
//                    }
//                });
//                PermissionUtils.openSetting();
                break;
        }
    }
//
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        Lg.i("onKeyDown:" + keyCode);
////        switch (keyCode) {
////            case KeyEvent.KEYCODE_BACK:
////                if (dg != null && dg.isShowing()) {
////                    dg.dismiss();
////                    return true;
////                }
////                break;
////        }
//        return super.onKeyDown(keyCode, event);
//    }

    //    @Override
//    public void onBackPressed() {
//        Lg.i("onBackPressed");
//        if (dg != null && dg.isShowing()) {
//            dg.dismiss();
//            return;
//        }
//        super.onBackPressed();
//    }
}
