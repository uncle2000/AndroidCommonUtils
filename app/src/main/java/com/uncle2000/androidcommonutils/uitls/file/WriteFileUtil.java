package com.uncle2000.androidcommonutils.uitls.file;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

import com.uncle2000.androidcommonutils.uitls.output.Logger;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import static com.uncle2000.androidcommonutils.uitls.file.CreatFileUtil.createFile;

/**
 * Created by 2000 on 2017/4/14.
 */

public class WriteFileUtil {

    public void clearTxtFile(String filePath) {
        try {
            // 首先构建一个文件输出流,用于向文件中写入数据.
            String text = "";
            FileOutputStream out = new FileOutputStream(filePath);
            // 构建一个写入器,用于向流中写入字符数据
            OutputStreamWriter writer = new OutputStreamWriter(out, "gb2312");
            writer.write(text);
            // 关闭Writer,关闭输出流
            writer.close();
            out.close();
        } catch (Exception e) {
            String ext = e.getLocalizedMessage();
            // Toast.makeText(this, ext, Toast.LENGTH_LONG).show();
        }
    }
//
//    /**
//     * 方法：把一段文本保存到给定的路径中.
//     */
//    public void saveTxtFile(String filePath, String text) {
//        try {
//            // 首先构建一个文件输出流,用于向文件中写入数据.
//            createFile(null, filePath, false);
//            String txt = readTextLine(filePath);
//            text = text + txt;
//            FileOutputStream out = new FileOutputStream(filePath);
//            // 构建一个写入器,用于向流中写入字符数据
//            OutputStreamWriter writer = new OutputStreamWriter(out, "gb2312");
//            writer.write(text);
//            // 关闭Writer,关闭输出流
//            writer.close();
//            out.close();
//        } catch (Exception e) {
//            String ext = e.getLocalizedMessage();
//            // Toast.makeText(this, ext, Toast.LENGTH_LONG).show();
//        }
//    }

    /**
     * 把数据输入到Path里的文件里
     *
     * @param path
     * @return
     */
    public File writeFromInputToSD(String path, byte[] b) {
        File file = null;
        OutputStream output = null;
        try {
            file = createFile(null, path, false);
            output = new FileOutputStream(file);
            output.write(b);
            output.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    /**
     * 把输入流中的数据输入到Path里的文件里
     *
     * @param path
     * @param inputStream
     * @return
     */
    public File writeFromInputToSD(String path, InputStream inputStream) {
        File file = null;
        OutputStream output = null;
        try {
            file = createFile(null, path, false);
            output = new FileOutputStream(file);
            byte[] buffer = new byte[4 * 1024];
            int temp;
            while ((temp = inputStream.read(buffer)) != -1) {
                output.write(buffer, 0, temp);
            }
            output.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return file;
    }
//
//    /**
//     * 将一个InputStream里面的数据写入到SD卡中
//     */
//    public static File write2SDFromInput(String path, String fileName, InputStream input) {
//        File file = null;
//        OutputStream output = null;
//        try {
//            creatSDDir(path);
//            file = createNewFile(path + "/" + fileName);
//            output = new FileOutputStream(file);
//            byte buffer[] = new byte[1024];
//            int len = -1;
//            while ((len = input.read(buffer)) != -1) {
//                output.write(buffer, 0, len);
//            }
//            output.flush();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                output.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return file;
//    }

    /**
     * 读取文件内容，从第startLine行开始，读取lineCount行
     *
     * @param file
     * @param startLine
     * @param lineCount
     * @return 读到文字的list, 如果list.size<lineCount则说明读到文件末尾了
     */
    public static List<String> readFile(File file, int startLine, int lineCount) {
        if (file == null || startLine < 1 || lineCount < 1) {
            return null;
        }
        if (!file.exists()) {
            return null;
        }
        FileReader fileReader = null;
        List<String> list = null;
        try {
            list = new ArrayList<String>();
            fileReader = new FileReader(file);
            LineNumberReader lineReader = new LineNumberReader(fileReader);
            boolean end = false;
            for (int i = 1; i < startLine; i++) {
                if (lineReader.readLine() == null) {
                    end = true;
                    break;
                }
            }
            if (end == false) {
                for (int i = startLine; i < startLine + lineCount; i++) {
                    String line = lineReader.readLine();
                    if (line == null) {
                        break;
                    }
                    list.add(line);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    /**
     * 向Text文件中写入内容
     *
     * @param
     * @param content
     * @return
     */
    public static boolean write(String path, String content) {
        return write(path, content, false);
    }

    public static boolean write(String path, String content, boolean append) {
        return write(new File(path), content, append);
    }

    public static boolean write(File file, String content) {
        return write(file, content, false);
    }

    /**
     * 写入文件
     *
     * @param file
     * @param content
     * @param append
     * @return
     */
    public static boolean write(File file, String content, boolean append) {
//        if (file == null || StringUtil.empty(content)) {
//            return false;
//        }
//        if (!file.exists()) {
//            file = createFile(null, file, false);
//        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file, append);
            fos.write(content.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            fos = null;
        }

        return true;
    }


    /**
     * 将图片保存到本地时进行压缩, 即将图片从Bitmap形式变为File形式时进行压缩,
     * 特点是: File形式的图片确实被压缩了, 但是当你重新读取压缩后的file为 Bitmap是,它占用的内存并没有改变
     *
     * @param bmp
     * @param file
     */
    public static void compressBmpToFile(Bitmap bmp, File file) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int options = 80;// 个人喜欢从80开始,
        bmp.compress(Bitmap.CompressFormat.JPEG, options, baos);
        while (baos.toByteArray().length / 1024 > 100) {
            baos.reset();
            options -= 10;
            bmp.compress(Bitmap.CompressFormat.JPEG, options, baos);
        }
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(baos.toByteArray());
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将图片从本地读到内存时,进行压缩 ,即图片从File形式变为Bitmap形式
     * 特点: 通过设置采样率, 减少图片的像素, 达到对内存中的Bitmap进行压缩
     *
     * @param srcPath
     * @return
     */
    public static Bitmap compressImageFromFile(String srcPath, float pixWidth, float pixHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;// 只读边,不读内容
        Bitmap bitmap = BitmapFactory.decodeFile(srcPath, options);

        options.inJustDecodeBounds = false;
        int w = options.outWidth;
        int h = options.outHeight;
        //float pixWidth = 800f;//
        //float pixHeight = 480f;//
        int scale = 1;
        if (w > h && w > pixWidth) {
            scale = (int) (options.outWidth / pixWidth);
        } else if (w < h && h > pixHeight) {
            scale = (int) (options.outHeight / pixHeight);
        }
        if (scale <= 0)
            scale = 1;
        options.inSampleSize = scale;// 设置采样率

        options.inPreferredConfig = Bitmap.Config.ARGB_8888;// 该模式是默认的,可不设
        options.inPurgeable = true;// 同时设置才会有效
        options.inInputShareable = true;// 。当系统内存不够时候图片自动被回收

        bitmap = BitmapFactory.decodeFile(srcPath, options);
        // return compressBmpFromBmp(bitmap);//原来的方法调用了这个方法企图进行二次压缩
        // 其实是无效的,大家尽管尝试
        return bitmap;
    }

    /**
     * 指定分辨率和清晰度的图片压缩
     */
    public void transImage(String fromFile, String toFile, int width, int height, int quality) {
        try {
            Bitmap bitmap = BitmapFactory.decodeFile(fromFile);
            int bitmapWidth = bitmap.getWidth();
            int bitmapHeight = bitmap.getHeight();
            // 缩放图片的尺寸
            float scaleWidth = (float) width / bitmapWidth;
            float scaleHeight = (float) height / bitmapHeight;
            Matrix matrix = new Matrix();
            matrix.postScale(scaleWidth, scaleHeight);
            // 产生缩放后的Bitmap对象
            Bitmap resizeBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmapWidth, bitmapHeight, matrix, false);
            // save file
            File myCaptureFile = new File(toFile);
            FileOutputStream out = new FileOutputStream(myCaptureFile);
            if (resizeBitmap.compress(Bitmap.CompressFormat.JPEG, quality, out)) {
                out.flush();
                out.close();
            }
            if (!bitmap.isRecycled()) {
                bitmap.recycle();//记得释放资源，否则会内存溢出
            }
            if (!resizeBitmap.isRecycled()) {
                resizeBitmap.recycle();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public void writeFile(Context context, File file, String words, int mode) {
        synchronized (file) {
            if (!file.exists()) {
                Logger.e("file does not exists");
            }
            if (!file.isFile()) {
                Logger.e("file is not a file");
            }
            if (!file.canWrite()) {
                Logger.e("file can not write");
            }
            if (mode != 0 && mode != 1 && mode != 2 && mode != 0x8000)//><
                Logger.e("0:private\n1public readable\n2public writeable 0x8000:append\ndefault is 0");
            else
                mode = 2;
            FileOutputStream outputStream;
            try {
                if (PathUtil.isSdCardExitOrCouldWrite())
                    outputStream = new FileOutputStream(file);
                else
                    outputStream = context.openFileOutput(file.getName(), mode);
                outputStream.write(words.getBytes());
                outputStream.flush();
                outputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
