package mzs.lib.utils.comm;

import android.os.Environment;

import java.io.File;

public class FilePathUtils {


    public static File getInFileDir() {
        return Utils.getApp().getFilesDir(); // /data/data/com.belt.wg.myutils/files
    }

    public static File getInCacheDir() {
        return Utils.getApp().getCacheDir();// /data/data/com.belt.wg.myutils/cache
    }

    public static File getExRootDir() {
        return Environment.getExternalStorageDirectory();// /storage/sdcard0
    }

    public static File getExPrivateDir(String type) {
        return Utils.getApp().getExternalFilesDir(type); // /storage/sdcard0/Android/data/com.belt.wg.myutils/files/{type}
    }

    public static File getExPrivateDir() {
        return Utils.getApp().getExternalFilesDir(""); // /storage/sdcard0/Android/data/com.belt.wg.myutils/files/{type}
    }


    public static File getExPublicDir(String type) {
        return Environment.getExternalStoragePublicDirectory(type); // /storage/sdcard0/{type}
    }

    public static File getExPublicDir() {
        return Environment.getExternalStoragePublicDirectory(""); // /storage/sdcard0/{type}
    }

    public static File getExCacheDir() {
        return Utils.getApp().getExternalCacheDir(); ///storage/sdcard0/Android/data/com.belt.wg.myutils/cache
    }


}
