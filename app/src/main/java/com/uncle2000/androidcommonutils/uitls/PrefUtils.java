package com.uncle2000.androidcommonutils.uitls;//package com.uncle2000.appcommonutils;
//
///**
// * Created by 2000 on 2017/3/20.
// */
//
//import android.content.Context;
//import android.content.SharedPreferences;
//
//public class PrefUtils {
//
//    public static boolean getBoolean(Context context, String key, boolean defalt) {
//        SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
//        Boolean b = sp.getBoolean(key, defalt);
//        return b;
//    }
//
//    public static void setBoolean(Context context, String key, Boolean value) {
//        SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
//        sp.edit().putBoolean(key, value).commit();
//    }
//
//    public static String getString(Context context, String key, String defalt) {
//        SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
//        String s = sp.getString(key, defalt);
//        return s;
//    }
//
//    public static void SetString(Context context, String key, String value) {
//        SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
//        sp.edit().putString(key, value).commit();
//
//    }
//
//    public static int getInt(Context context, String key, int defalt) {
//        SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
//        int l = sp.getInt(key, defalt);
//        return l;
//    }
//
//    public static void SetInt(Context context, String key, int value) {
//        SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
//        sp.edit().putInt(key, value).commit();
//
//    }
//
//    public static long getLong(Context context, String key, long defalt) {
//        SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
//        long l = sp.getLong(key, defalt);
//        return l;
//    }
//
//    public static void SetLong(Context context, String key, long value) {
//        SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
//        sp.edit().putLong(key, value).commit();
//
//    }
//}