package zsy.base.android.wrapper.log;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import zsy.base.java.utils.VerifyUtils;

/**
 * Created by 24275 on 2016/9/29.
 */

public class LoggerWrapper {


//    private static final int MethodCount = 2;
//    private static final int MethodOffset = 3;
//    private static final String DEFAULT_BASE_TAG = "Logger";

    private static Class<?> loggerClazz = getLoggerClazz();


    private static int methodCount = 2;
    private static int methodOffset = 3;
    private static String baseTag = "Logger";

    private static boolean isInited = false;

    public static void setMethodCount(int methodCount) {
        LoggerWrapper.methodCount = methodCount;
    }

    public static void setMethodOffset(int methodCount) {
        LoggerWrapper.methodOffset = methodCount;
    }

    public static void setBaseTag(String baseTag) {
        LoggerWrapper.baseTag = baseTag;
    }

    public static boolean isAvaliable() {
        return loggerClazz != null;
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


    public static void init() {
        try {
            initLogger();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    private static void initLogger() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        isInited = true;
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


    private static void addTag(String tag) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (!VerifyUtils.isEmpty(tag)) {
            Method method = loggerClazz.getDeclaredMethod("t", String.class);
            method.setAccessible(true);
            method.invoke(null, tag);
        }
    }


    private static void print(String msg, String level) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = loggerClazz.getDeclaredMethod(level, String.class, Object[].class);
        method.setAccessible(true);
        method.invoke(null, String.valueOf(msg), new Object[]{});
    }

    private static void l(String tag, String msg, String level) {
        try {
            if (!isInited) {
                initLogger();
            }
            addTag(tag);
            print(msg, level);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
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

}