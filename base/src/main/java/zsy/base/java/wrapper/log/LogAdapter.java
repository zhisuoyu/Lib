package zsy.base.java.wrapper.log;

public interface LogAdapter {

    boolean isLoggable();

    void log(int level, String tag, String msg);

}
