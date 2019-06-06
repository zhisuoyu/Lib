package zsy.base.java.utils;//package com.zsy.adnv.utils;

import java.util.Arrays;

import zsy.base.java.wrapper.log.Lg;


public class ArrayUtils {

    public static void main(String[] args) {
//        String[] arr = new String[]{"hello", "world"};
//        String element = "hello";
//        String element2 = "mzs";
//        Lg.i("hello", "rt:" + contain(arr, element));
//        Lg.i("mzs", "rt:" + contain(arr, element2));

        String[] arr1 = new String[]{"111111", "22222"};
        String[] arr2 = new String[]{"333333", "444444"};
        Lg.i("String", Arrays.toString(concat(new String[totalLen(arr1, arr2)], arr1, arr2)));

//        Lg.i("String", Arrays.toString(concat(new String[]{"111111", "22222"}, new String[]{"333333", "444444"})));
//        Lg.i("Integer", Arrays.toString(concat(new Integer[]{1, 2}, new Integer[]{3, 4},new Integer[]{5,6,7},new String[]{"ccasd", "cbm"})));
//        Lg.i("Integer", Arrays.toString(ArrayUtils.<Integer>concat(new Integer[]{1, 2}, new Integer[]{3, 4},new Integer[]{5,6,7})));
    }


    public static int totalLen(Object[]... array) {
        int totalLen = 0;
        for (Object[] element : array) {
            if (element == null) {
                continue;
            }
            totalLen += element.length;
        }
        return totalLen;
    }

    public static <T> T[] concat(T[] des, T[]... src) {
        VerifyUtils.requireNonNull(src, "params is null");
        if (src.length == 1) {
            return src[0];
        }
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
