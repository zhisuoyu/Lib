package zsy.base.android.wrapper.log;

import android.util.Log;

import zsy.base.java.wrapper.log.AssembleLog;


public class AndLog extends AssembleLog {

    @Override
    public void println(String tag, String msg, int level) {
        String rt = SPACE + BK + assemble(getBaseTag(), tag, msg);
        String aTag = tagInfo(getBaseTag(), tag);
        level = adjustLevel(level);
        switch (level) {
            case VERBOSE:
                Log.v(aTag, rt);
                break;
            case DEBUG:
                Log.d(aTag, rt);
                break;
            case INFO:
                Log.i(aTag, rt);
                break;
            case WARN:
                Log.w(aTag, rt);
                break;
            case ERROR:
                Log.e(aTag, rt);
                break;
        }
    }

    @Override
    public String prefix() {
        return "";
    }

    @Override
    public String des(String prefix, String baseTag, String tag) {
        return prefix + BORDER_V + SPACE + threadInfo();
    }
}
