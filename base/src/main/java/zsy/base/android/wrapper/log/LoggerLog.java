package zsy.base.android.wrapper.log;


import zsy.base.java.wrapper.log.AbsLog;

public class LoggerLog extends AbsLog {

    public LoggerLog() {
        LoggerWrapper.setMethodOffset(9);
        LoggerWrapper.setMethodCount(2);
        LoggerWrapper.setBaseTag(getBaseTag());
        LoggerWrapper.init();
    }

    @Override
    public void setBaseTag(String baseTag) {
        LoggerWrapper.setBaseTag(getBaseTag());
    }

    @Override
    public void println(String tag, String msg, int level) {
        switch (level) {
            case VERBOSE:
                LoggerWrapper.v(tag, msg);
                break;
            case DEBUG:
                LoggerWrapper.d(tag, msg);
                break;
            case INFO:
                LoggerWrapper.i(tag, msg);
                break;
            case WARN:
                LoggerWrapper.w(tag, msg);
                break;
            case ERROR:
                LoggerWrapper.e(tag, msg);
                break;
        }
    }


}
