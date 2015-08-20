package com.vlabs.droidmasked.util;

import java.util.Arrays;

/**
 * Created by vilmar.filho on 8/20/15.
 */
public class Util {

    public static String[] mergeArrayString(String s, String[] arr) {
        String[] localSeries = Arrays.copyOf(arr, arr.length + 1);
        localSeries[arr.length] = s;
        return localSeries;
    }


    public static String[] concatArrayString(String[] a, String[] b) {
        int aLen = a.length;
        int bLen = b.length;
        String[] c = new String[aLen+bLen];
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);
        return c;
    }

}
