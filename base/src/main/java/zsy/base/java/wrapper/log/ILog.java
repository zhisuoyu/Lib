package zsy.base.java.wrapper.log;

public interface ILog {

    int VERBOSE = 2;
    int DEBUG = 3;
    int INFO = 4;
    int WARN = 5;
    int ERROR = 6;
    int ASSERT = 7;

    String DEFAULT_BASE_TAG = "Lg";

    void setBaseTag(String baseTag);

    String getBaseTag();

    void setLevel(int level);

    int getLevel();

    void l(String tag, String msg, int level);

    void println(String tag, String msg, int level);

    boolean isAvailable();


}
