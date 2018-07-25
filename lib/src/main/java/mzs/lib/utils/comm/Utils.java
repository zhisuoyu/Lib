package mzs.lib.utils.comm;

import android.content.Context;

public class Utils {


    private static Context context;

    public static void init(Context context) {
        Utils.context = context;
    }

    public static Context getApp() {
        if (context == null) {
            throw new NullPointerException("Utils is not inited");
        }
        return context;
    }

}
