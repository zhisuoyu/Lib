package zsy.base.java.wrapper.log;

import java.util.concurrent.TimeUnit;

import zsy.base.java.utils.VerifyUtils;

public class Lg {

    public static final boolean DEBUG = true;

    public static void main(String[] args) {
        Lg.i("Test", "hello");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Lg.e("world");
    }

    private static final ILog DEFAULT_ILG = new AssembleLog();
    private static ILog iLog;

    public static void setILog(ILog iLog) {
        VerifyUtils.requireNonNull(iLog, "iLog is null");
        if (iLog.isAvailable()) {
            Lg.iLog = iLog;
        }
    }


    private static void l(String tag, String msg, int level) {
        if (!DEBUG) {
            return;
        }
        if (iLog == null) {
            DEFAULT_ILG.l(tag, msg, level);
        } else {
            iLog.l(tag, msg, level);
        }
    }


    public static void v(String tag, String msg) {
        l(tag, msg, ILog.VERBOSE);
    }

    public static void v(String msg) {
        v(null, msg);
    }


    public static void d(String tag, String msg) {
        l(tag, msg, ILog.DEBUG);
    }

    public static void d(String msg) {
        d(null, msg);
    }


    public static void i(String tag, String msg) {
        l(tag, msg, ILog.INFO);
    }

    public static void i(String msg) {
        i(null, msg);
    }


    public static void w(String tag, String msg) {
        l(tag, msg, ILog.WARN);
    }

    public static void w(String msg) {
        w(null, msg);
    }


    public static void e(String tag, String msg) {
        l(tag, msg, ILog.ERROR);
    }

    public static void e(String msg) {
        e(null, msg);
    }


}
