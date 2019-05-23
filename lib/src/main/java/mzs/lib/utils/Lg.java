package mzs.lib.utils;

import android.text.TextUtils;
import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by 24275 on 2016/9/29.
 */

public class Lg {

    private static final boolean IsDebug = true; //true print;false not print

    private static final String BaseTag = "Lg";

    private static final int MethodCount = 2;
    private static final int MethodOffset = 3;

    private static Class<?> loggerClazz = getLoggerClazz();


    private static boolean isLoggerInited = false;

    private static String baseTag = BaseTag;
    private static int methodCount = MethodCount;
    private static int methodOffset = MethodOffset;

    private static Mode mode = Mode.Logger;


    public static void setMode(Mode mode) {
        Lg.mode = mode;
    }

    public static void setBaseTag(String baseTag) {
        Lg.baseTag = baseTag;
    }

    public static void setMethodCount(int methodCount) {
        Lg.methodCount = methodCount;
    }

    public static void setMethodOffset(int methodCount) {
        Lg.methodOffset = methodCount;
    }


    public static void init(Mode mode, String baseTag, int methodCount, int methodOffset) {
        if (!IsDebug) {
            return;
        }
        setBaseTag(baseTag);
        if (mode == Mode.Logger && isLoggerLoaded()) {
            isLoggerInited = true;
            try {
                setMethodCount(methodCount);
                setMethodOffset(methodOffset);
                initLogger();
                setMode(Mode.Logger);
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        setMode(Mode.Log);

    }


    private static Class<?> getLoggerClazz() {
        Class<?> clazz = null;
        try {
            clazz = Class.forName("com.orhanobut.logger.Logger");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz;
    }

    private static boolean isLoggerLoaded() {
        return loggerClazz != null;
    }


    private static void initLogger() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> pfsClazz = Class.forName("com.orhanobut.logger.PrettyFormatStrategy");
        Method newBuilderMethod = pfsClazz.getDeclaredMethod("newBuilder");
        newBuilderMethod.setAccessible(true);
        Object builder = newBuilderMethod.invoke(null);

        Class<?> builderClazz = Class.forName("com.orhanobut.logger.PrettyFormatStrategy$Builder");

        Method method1 = builderClazz.getDeclaredMethod("showThreadInfo", boolean.class);
        method1.setAccessible(true);
        method1.invoke(builder, true);

        Method method2 = builderClazz.getDeclaredMethod("methodCount", int.class);
        method2.setAccessible(true);
        method2.invoke(builder, methodCount);

        Method method3 = builderClazz.getDeclaredMethod("methodOffset", int.class);
        method3.setAccessible(true);
        method3.invoke(builder, methodOffset);

        Method method4 = builderClazz.getDeclaredMethod("tag", String.class);
        method4.setAccessible(true);
        method4.invoke(builder, baseTag);

        Method method5 = builderClazz.getDeclaredMethod("build");
        method5.setAccessible(true);
        Object fs = method5.invoke(builder);


//        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
//                .showThreadInfo(true)  // (Optional) Whether to show thread info or not. Default true
//                .methodCount(methodCount)         // (Optional) How many method line to show. Default 2
//                .methodOffset(methodOffset)        // (Optional) Hides internal method calls up to offset. Default 5
////                .logStrategy(customLog) // (Optional) Changes the log strategy to print out. Default LogCat
//                .tag(tag)   // (Optional) Global tag for every log. Default PRETTY_LOGGER
//                .build();
//        new AndroidLogAdapter()
        Class<?> adapterClazz = Class.forName("com.orhanobut.logger.AndroidLogAdapter");
        Constructor constructor = adapterClazz.getDeclaredConstructor(Class.forName("com.orhanobut.logger.FormatStrategy"));
        constructor.setAccessible(true);
        Object adapter = constructor.newInstance(fs);
        Class<?> loggerClazz = Class.forName("com.orhanobut.logger.Logger");
        Method addLogAdapterMethod = loggerClazz.getDeclaredMethod("addLogAdapter", Class.forName("com.orhanobut.logger.LogAdapter"));
        addLogAdapterMethod.setAccessible(true);
        addLogAdapterMethod.invoke(null, adapter);
//        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
    }


    public static void addTag(String tag) {
        if (!TextUtils.isEmpty(tag)) {
            try {
                Method method = loggerClazz.getDeclaredMethod("t", String.class);
                method.setAccessible(true);
                method.invoke(null, tag);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void l(String tag, String msg, String level) {
        if (!IsDebug) {
            return;
        }
        if (mode == Mode.Logger && !isLoggerInited) {
            init(Mode.Logger, BaseTag, MethodCount, MethodOffset);
        }
        if (mode == Mode.Logger) {
            addTag(tag);
            try {
                Method method = loggerClazz.getDeclaredMethod(level, String.class, Object[].class);
                method.setAccessible(true);
                method.invoke(null, String.valueOf(msg), new Object[]{});
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            Class clazz = Log.class;
            Method method = clazz.getDeclaredMethod(level, String.class, String.class);
            if (method != null) {
                method.setAccessible(true);
                tag = tag == null ? baseTag : baseTag + "-" + tag;
                method.invoke(null, tag, String.valueOf(msg));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void v(String tag, String msg) {
        l(tag, msg, "v");
    }

    public static void v(String msg) {
        l(null, msg, "v");
    }


    public static void d(String tag, String msg) {
        l(tag, msg, "d");
    }

    public static void d(String msg) {
        l(null, msg, "d");
    }


    public static void i(String tag, String msg) {
        l(tag, msg, "i");
    }

    public static void i(String msg) {
        l(null, msg, "i");
    }


    public static void w(String tag, String msg) {
        l(tag, msg, "w");
    }

    public static void w(String msg) {
        l(null, msg, "w");
    }


    public static void e(String tag, String msg) {
        l(tag, msg, "e");
    }

    public static void e(String msg) {
        l(null, msg, "e");
    }


    public static void wtf(String tag, String msg) {
        l(tag, msg, "wtf");
    }

    public static void wtf(String msg) {
        l(null, msg, "wtf");
    }

    public enum Mode {
        Log, Logger
    }
}