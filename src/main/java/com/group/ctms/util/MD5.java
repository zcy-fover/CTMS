package com.group.ctms.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by zcy-fover on 2016/11/2.
 * 加密算法，用于加密密码
 */
public class MD5 {
    public static String get(String src){
        String result = "";
        if (src == null || src.length() < 1){
            return result;
        } else {
            try{
                MessageDigest digest = MessageDigest.getInstance("MD5");
                digest.update(src.getBytes("UTF-8"));
                result = byteToHex(digest.digest());
            } catch (UnsupportedEncodingException | NoSuchAlgorithmException e){
                e.printStackTrace();
            }
            return result;
        }
    }

    public static String byteToHex(byte[] bytes){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++){
//            System.out.print(bytes[i]);
            int num = 0xFF & bytes[i];
            if (num < 0x10){
                builder.append("0" + Integer.toHexString(num));
            } else {
                builder.append(Integer.toHexString(num));
            }
        }
        System.out.println();
        return builder.toString();
    }
}
