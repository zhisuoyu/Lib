package zsy.base.android.wrapper.log;

import android.util.Log;

import zsy.base.java.wrapper.log.Printer;

public class AndroidPrinter implements Printer {
    @Override
    public boolean isPrefix() {
        return false;
    }

    @Override
    public void println(int level, String baseTag, String tag, String msg) {
        String tagInfo = tag == null ? baseTag : baseTag + "-" + tag;
        Log.i(tagInfo, msg);
    }
}
