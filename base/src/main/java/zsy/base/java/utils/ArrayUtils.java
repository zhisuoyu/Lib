package zsy.base.java.utils;//package com.zsy.adnv.utils;

public class ArrayUtils {

//    public static void main(String[] args) {
//
//        String[] arr1 = new String[]{"111111", "22222"};
//        String[] arr2 = new String[]{"333333", "444444"};
//        String[] arr3 = new String[]{"555555", "666666"};
//        Lg.i("String", Arrays.toString(concat(arr1, arr2, arr3)));
//        long startMs = System.currentTimeMillis();
//        for (int i = 0; i < 10000000; i++) {
//            concat(arr1, arr2, arr3);
//        }
//        long endMs = System.currentTimeMillis();
//        Lg.i("disMs:" + (endMs - startMs));
//    }
//

    public static <T> T[] concat(T[]... src) throws NullPointerException {
        VerifyUtils.requireNonNull(src, "params is null");
        if (src.length == 1) {
            return src[0];
        }
        int totalLen = 0;
        for (T[] e : src) {
            if (e == null) {
                continue;
            }
            totalLen += e.length;
        }
        T[] des = (T[]) new Object[totalLen];
        int currentLen = 0;
        for (T[] object : src) {
            if (object == null) {
                continue;
            }
            System.arraycopy(object, 0, des, currentLen, object.length);
            currentLen += object.length;
        }
        return des;
    }

//    public static int totalLen(Object[]... array) {
//        int totalLen = 0;
//        for (Object[] element : array) {
//            if (element == null) {
//                continue;
//            }
//            totalLen += element.length;
//        }
//        return totalLen;
//    }

//    public static <T> T[] concat(T[]... src) {
//        VerifyUtils.requireNonNull(src, "params is null");
//        List<String> list = new ArrayList<>();
//        if (src.length == 1) {
//            return src[0];
//        }
//        int currentLen = 0;
//        for (T[] object : src) {
//            if (object == null) {
//                continue;
//            }
//            System.arraycopy(object, 0, des, currentLen, object.length);
//            currentLen += object.length;
//        }
//        return des;
//    }

//    public static <T> T[] concat(T[]... src) {
//        VerifyUtils.requireNonNull(src, "params is null");
//        if (src.length == 1) {
//            return src[0];
//        }
//        List<T> list = new ArrayList<>();
//        for (T[] object : src) {
//            if (object == null) {
//                continue;
//            }
//            list.addAll(Arrays.asList(object));
//        }
//        return (T[]) list.toArray();
//    }

    public static <T> boolean contain(T[] array, T element) {
        VerifyUtils.requireNonNull(array, "array is null");
        VerifyUtils.requireNonNull(element, "element is null");
        for (T a : array) {
            if (element.equals(a)) {
                return true;
            }
        }
        return false;

    }
}
