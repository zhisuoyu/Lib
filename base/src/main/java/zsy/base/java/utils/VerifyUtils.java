package zsy.base.java.utils;

public class VerifyUtils {

    /**
     * Verify if the object is not null , or throws a NullPointerException
     * with the given message.
     */
    public static void requireNonNull(Object object, String message) {
        if (object == null) {
            throw new NullPointerException(message);
        }
    }

    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }
}
