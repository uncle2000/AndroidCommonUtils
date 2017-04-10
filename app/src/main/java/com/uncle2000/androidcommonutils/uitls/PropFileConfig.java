//package com.uncle2000.androidcommonutils.uitls;
//
//import java.util.Arrays;
//
///**
// * Created by 2000 on 2017/4/10.
// */
//
//public class PropFileConfig {
//
//    private static final String SYS_CONFIG_FILE_NAME = "config.properties";
//    private static PropertiesConfiguration config;
//
//    static {
//        try {
//            config = new PropertiesConfiguration(SYS_CONFIG_FILE_NAME);
//        } catch (ConfigurationException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public static String getProperty(String key) {
//        String value = config.getString(key);
//        return (value == null) ? "" : value;
//    }
//
//    public static String getPropertys(String key) {
//        String[] value = config.getStringArray(key);
//        return (value == null) ? "" : Arrays.toString(value).replace("[", "").replace("]", "");
//    }
//
//    public static String[] getPropertyArray(String key) {
//        String[] value = config.getStringArray(key);
//        return (value == null) ? new String[]{} : value;
//    }
//
//    public static void removeProperty(String key) {
//        config.clearProperty(key);
//    }
//
//    public static void setProperty(String key, String value) {
//        config.setProperty(key, value);
//    }
//
//    public static void saveChange() {
//        try {
//            config.save();
//        } catch (ConfigurationException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
