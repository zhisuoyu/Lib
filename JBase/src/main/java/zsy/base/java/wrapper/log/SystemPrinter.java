package zsy.base.java.wrapper.log;

public enum SystemPrinter implements Printer {
    INSTACNE;

//    @Override
//    public void println(int level, String baseTag, String tag, String msg, String prefix) {
//        String s = prefix + msg;
//        if (level <= Lg.INFO) {
//            System.out.println(s);
//        } else {
//            System.err.println(s);
//        }
//    }


    @Override
    public boolean isPrefix() {
        return true;
    }

    @Override
    public void println(int level, String baseTag, String tag, String msg) {
        if (level <= Lg.INFO) {
            System.out.println(msg);
        } else {
            System.err.println(msg);
        }
    }
}
