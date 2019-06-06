package zsy.base.java.wrapper.log;

public interface Printer {

    boolean isPrefix();

    void println(int level, String baseTag, String tag, String msg);
}
