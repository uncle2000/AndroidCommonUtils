package com.uncle2000.androidcommonutils.uitls.encryption;

/**
 * Created by 2000 on 2017/3/30.
 */

public class BASE64Utils {
//1.）字符串进行Base64编码
//
//    String encodedString = Base64.encodeToString("whoislcj".getBytes(), Base64.DEFAULT);
// Log.e("Base64", "Base64---->" + encodedString);
//
//2.）字符串进行Base64解码
//
//    String decodedString =new String(Base64.decode(encodedString,Base64.DEFAULT));
// Log.e("Base64", "Base64---->" + decodedString);
//
// 3.）对文件进行Base64编码
//            复制代码
//
//    File file = new File("/storage/emulated/0/pimsecure_debug.txt");
//    FileInputStream inputFile = null;
//try {
//        inputFile = new FileInputStream(file);
//        byte[] buffer = new byte[(int) file.length()];
//        inputFile.read(buffer);
//        inputFile.close();
//        encodedString = Base64.encodeToString(buffer, Base64.DEFAULT);
//        Log.e("Base64", "Base64---->" + encodedString);
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//
//    复制代码
// 4.）对文件进行Base64解码
//            复制代码
//
//    File desFile = new File("/storage/emulated/0/pimsecure_debug_1.txt");
//    FileOutputStream  fos = null;
//try {
//        byte[] decodeBytes = Base64.decode(encodedString.getBytes(), Base64.DEFAULT);
//        fos = new FileOutputStream(desFile);
//        fos.write(decodeBytes);
//        fos.close();
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
}
