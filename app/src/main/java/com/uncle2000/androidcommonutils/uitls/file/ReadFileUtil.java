package com.uncle2000.androidcommonutils.uitls.file;

import com.uncle2000.androidcommonutils.uitls.output.Logger;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;

/**
 * Created by 2000 on 2017/4/14.
 */

public class ReadFileUtil {

    // 读取一个给定的文本文件内容,并把内容以一个字符串的形式返回
    public String readTextLine(String textFile) {
        try {
            // 首先构建一个文件输入流,该流用于从文本文件中读取数据
            FileInputStream input = new FileInputStream(textFile);
            // 为了能够从流中读取文本数据,我们首先要构建一个特定的Reader的实例,
            // 因为我们是从一个输入流中读取数据,所以这里适合使用InputStreamReader.
            InputStreamReader streamReader = new InputStreamReader(input,
                    "gb2312");
            // 为了能够实现一次读取一行文本的功能,我们使用了 LineNumberReader类,
            // 要构建LineNumberReader的实例,必须要传一个Reader实例做参数,
            // 我们传入前面已经构建好的Reder.
            LineNumberReader reader = new LineNumberReader(streamReader);
            // 字符串line用来保存每次读取到的一行文本.
            String line = null;
            // 这里我们使用一个StringBuilder来存储读取到的每一行文本,
            // 之所以不用String,是因为它每次修改都会产生一个新的实例,
            // 所以浪费空间,效率低.
            StringBuilder allLine = new StringBuilder();
            // 每次读取到一行,直到读取完成
            while ((line = reader.readLine()) != null) {
                allLine.append(line);
                // 这里每一行后面,加上一个换行符,LINUX中换行是”\n”,
                // windows中换行是”\r\n”.
                allLine.append("\n");
            }
            // 把Reader和Stream关闭
            streamReader.close();
            reader.close();
            input.close();
            // 把读取的字符串返回
            return allLine.toString();
        } catch (Exception e) {
            // Toast.makeText(this, e.getLocalizedMessage(),
            // Toast.LENGTH_LONG).show();
            return "";
        }
    }

//    /**
//     * 读取文件内容 从文件中一行一行的读取文件
//     *
//     * @param file
//     * @return
//     */
//    public static String readFile(File file) {
//        Reader read = null;
//        String content = "";
//        String result = "";
//        BufferedReader br = null;
//        try {
//            read = new FileReader(file);
//            br = new BufferedReader(read);
//            while ((content = br.readLine().toString().trim()) != null) {
//                result += content + "\r\n";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                read.close();
//                br.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return result;
//    }
//
//    public String readFile(File file) {
//        synchronized (file) {
//            if (!file.exists()) {
//                Logger.e("file does not exists");
//                return "";
//            }
//            if (!file.isFile()) {
//                Logger.e("file is not a file");
//                return "";
//            }
//            if (!file.canRead()) {
//                Logger.e("file can not read");
//                return "";
//            }
//            long readSize = 8;
//            try {
//                FileInputStream inputStream = context.openFileInput(file.getName());
//                byte[] bytes = new byte[(int) (file.length() < readSize ? file.length() : readSize)];
//                ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
//                while (inputStream.read(bytes) != -1) {
//                    arrayOutputStream.write(bytes, 0, bytes.length);
//                }
//                inputStream.close();
//                arrayOutputStream.close();
//                String content = new String(arrayOutputStream.toByteArray());
//                return content;
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//                return "";
//            } catch (IOException e) {
//                e.printStackTrace();
//                return "";
//            } catch (NullPointerException e) {
//                e.printStackTrace();
//                return "";
//            }
//        }
//    }
}
