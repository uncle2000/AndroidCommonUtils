//package com.uncle2000.androidcommonutils.uitls;
//
///**
// * Created by 2000 on 2017/4/10.
// */
//
//public class PinyinUtils {
////    1.首先下载pinyin4j-2.5.0.jar,拷贝到工程的lib目录里
//
//    /**
//     * 根据传入的字符串(包含汉字),得到拼音
//     *
//     * @param str 字符串
//     * @return
//     */
//    public static String getPinyin(String str) {
//
//        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
//        format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
//        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
//
//        StringBuilder sb = new StringBuilder();
//
//        char[] charArray = str.toCharArray();
//        for (int i = 0; i < charArray.length; i++) {
//            char c = charArray[i];
//            // 如果是空格, 跳过
//            if (Character.isWhitespace(c)) {
//                continue;
//            }
//            if (c >= -127 && c < 128) {
//                // 肯定不是汉字
//                sb.append(c);
//            } else {
//                String s = "";
//                try {
//                    // 通过char得到拼音集合. 单 -> dan, shan
//                    s = PinyinHelper.toHanyuPinyinStringArray(c, format)[0];
//                    sb.append(s);
//                } catch (BadHanyuPinyinOutputFormatCombination e) {
//                    e.printStackTrace();
//                    sb.append(s);
//                }
//            }
//        }
//
//        return sb.toString();
//    }
//
//}
