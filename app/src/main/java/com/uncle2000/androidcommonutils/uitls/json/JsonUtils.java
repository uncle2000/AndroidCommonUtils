//package com.uncle2000.androidcommonutils.uitls.json;
//
//import java.util.List;
//
///**
// * Created by 2000 on 2017/4/10.
// */
//
//public class JsonUtils {
//    private static Gson gson = new GsonBuilder().serializeNulls().create();
//
//    public static String toJson(Object obj) {
//        return gson.toJson(obj);
//    }
//
//    public static <T> List<T> parseJsonToList(String json) {
//        Gson gson1 = new Gson();
//        return gson1.fromJson(json, new TypeToken<List<T>>() {}.getType());
//    }
//}