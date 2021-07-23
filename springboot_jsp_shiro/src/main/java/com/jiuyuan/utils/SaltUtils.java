package com.jiuyuan.utils;

import java.util.Random;

/**
 * @author shkstart
 * @create 2021-07-23 15:35
 */
public class SaltUtils {
    public static String getSalt(int n){
        char[] chars = "ABCDEFGHIJKLMDZ123578!@#)".toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char aChar = chars[new Random().nextInt(chars.length)];
            stringBuilder.append(aChar);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(getSalt(8));
    }
}
