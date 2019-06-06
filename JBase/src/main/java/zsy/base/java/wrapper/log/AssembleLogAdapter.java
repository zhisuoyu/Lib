package zsy.base.java.wrapper.log;

public class AssembleLogAdapter implements LogAdapter {


    private ILogFormat ILogFormat;

    public AssembleLogAdapter(ILogFormat ILogFormat) {
        this.ILogFormat = ILogFormat;
    }

    @Override
    public boolean isLoggable() {
        return true;
    }

    @Override
    public void log(int level, String tag, String msg) {
        ILogFormat.log(level, tag, msg);
    }


}
