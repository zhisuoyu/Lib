//package zsy.base.lg.android;
//
//import android.util.Log;
//
//import zsy.base.lg.java.Lg;
//import zsy.base.lg.java.LogAdapter;
//
//public enum AndroidAdapter implements LogAdapter {
//    INSTANCE;
//
//
//    @Override
//    public boolean isLoggable() {
//        return true;
//    }
//
//
//    @Override
//    public void log(int level, String tag, String msg) {
//        switch (level) {
//            case Lg.VERBOSE:
//                Log.v(tag, msg);
//                break;
//            case Lg.DEBUG:
//                Log.d(tag, msg);
//                break;
//            case Lg.INFO:
//                Log.i(tag, msg);
//                break;
//            case Lg.WARN:
//                Log.w(tag, msg);
//                break;
//            case Lg.ERROR:
//                Log.e(tag, msg);
//                break;
//        }
//    }
//}
