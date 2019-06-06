package zsy.base.java.wrapper.log;

public class Lg {
    public static final int VERBOSE = 2;
    public static final int DEBUG = 3;
    public static final int INFO = 4;
    public static final int WARN = 5;
    public static final int ERROR = 6;

    public static final LogAdapter DEFAULT_LOG_ADAPTER = new AssembleLogAdapter(new LogFormat.Builder().build());

    private static LogAdapter logAdapter;


    public static void main(String[] args) {
//        Lg.i("Test", "hello");
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Lg.e("world");

        Lg.setLogAdapter(new AssembleLogAdapter(
                new LogFormat.Builder()
                        .setBaseTag("Lg")
                        .setShowDesInfo(true)
                        .setMinLevel(DEBUG)
                        .setMethodOffset(4)
                        .setShowMethodTrace(true)
                        .build()));
        Lg.w("jj", "hello");
        Lg.v("jj", "hello");
    }


    public static void setLogAdapter(LogAdapter logAdapter) {
        Lg.logAdapter = logAdapter;
    }


    private static LogAdapter getLogAdapter() {
        return logAdapter != null && logAdapter.isLoggable() ? logAdapter : DEFAULT_LOG_ADAPTER;
    }

    private static void l(int level, String tag, String msg) {
        getLogAdapter().log(level, tag, msg);
    }


    public static void v(String tag, String msg) {
        l(VERBOSE, tag, msg);
    }

    public static void v(String msg) {
        v(null, msg);
    }


    public static void d(String tag, String msg) {
        l(DEBUG, tag, msg);
    }

    public static void d(String msg) {
        d(null, msg);
    }


    public static void i(String tag, String msg) {
        l(INFO, tag, msg);
    }

    public static void i(String msg) {
        i(null, msg);
    }


    public static void w(String tag, String msg) {
        l(WARN, tag, msg);
    }

    public static void w(String msg) {
        w(null, msg);
    }


    public static void e(String tag, String msg) {
        l(ERROR, tag, msg);
    }

    public static void e(String msg) {
        e(null, msg);
    }


}
