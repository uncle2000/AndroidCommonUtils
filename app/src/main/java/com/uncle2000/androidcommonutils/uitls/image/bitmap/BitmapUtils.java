package com.uncle2000.androidcommonutils.uitls.image.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by 2000 on 2017/4/10.
 */

public class BitmapUtils {

    private static Map<String, SoftReference<Bitmap>> imageCache = new HashMap<String, SoftReference<Bitmap>>();

    public static void addBitmapToCache(String path) {
        // 强引用的Bitmap对象
        Bitmap bitmap = BitmapFactory.decodeFile(path);
        // 软引用的Bitmap对象
        SoftReference<Bitmap> softBitmap = new SoftReference<Bitmap>(bitmap);
        // 添加该对象到Map中使其缓存
        imageCache.put(path, softBitmap);
    }

    public static Bitmap getBitmapByPath(String path) {
        // 从缓存中取软引用的Bitmap对象
        SoftReference<Bitmap> softBitmap = imageCache.get(path);
        // 判断是否存在软引用
        if (softBitmap == null) {
            return null;
        }
        // 取出Bitmap对象，如果由于内存不足Bitmap被回收，将取得空
        Bitmap bitmap = softBitmap.get();
        return bitmap;
    }

    /**
     * @param drawable
     * @return
     */
    public static Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(
                drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(),
                drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                        : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        // canvas.setBitmap(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    public static String getBase64(byte[] image) {
        String string = "";
        try {
//            BASE64Encoder encoder = new BASE64Encoder();
//            string = encoder.encodeBuffer(image).trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return string;
    }

    /**
     * @param R_DRAWABLE_ID
     * @return
     */

    @SuppressWarnings("deprecation")
    public static Drawable getDrawable(byte[] imgByte) {
        Bitmap bitmap;
        if (imgByte != null) {
            bitmap = BitmapFactory.decodeByteArray(imgByte, 0, imgByte.length);
            Drawable drawable = new BitmapDrawable(bitmap);

            return drawable;
        }
        return null;
    }

    /**
     * 閫氳繃bitmap 鑾峰彇浜岃繘鍒舵暟鎹?
     * @param image
     * @return
     */
    public static byte[] getDefaultIcon(Bitmap image) {
        // iconView.get
        // BitmapFactory.
        byte[] compressData = null;
        if (image != null) {
            compressData = getByteByBitmap(image);
        }
        return compressData;
    }

    private static byte[] getByteByBitmap(Bitmap bmp) {
        Bitmap output = Bitmap.createScaledBitmap(bmp, 150, bmp.getHeight()
                * 150 / bmp.getWidth(), true);
        // 涓?畾瑕佸垽鏂紝濡傛灉鍥剧墖鍘嬬缉鍓嶅悗width,height涓嶅彉锛?
        // 寮曠敤鍚屼竴涓璞★紝绯荤粺浼氭姤
        // Canvas: trying to use a recycled bitmap android.graphics.Bitmap閿欒
        if (bmp != output) {
            bmp.recycle();
            bmp = null;
        }
        byte[] compressData = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            try {
                output.compress(Bitmap.CompressFormat.PNG, 100, baos);
            } catch (Exception e) {
                e.printStackTrace();
            }
            compressData = baos.toByteArray();
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return compressData;
    }

    /**
     * @param bitmap
     * @param _width
     * @param _height
     * @return
     */
    public static Bitmap setBitmapSize(Bitmap bitmap, int _width, int _height) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int newWidth = _width;
        int newHeight = _height;
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    /**
     * @param bitmap
     * @param _width
     * @param _height
     * @return
     */
    public static Bitmap setBitmapSize(String bitmapPath, int _width,
                                       int _height) {
        Bitmap bitmap = BitmapFactory.decodeFile(bitmapPath);
        if (bitmap == null) {
//            Logger.i("bitmap", "bitmap------------>发生未知异常！");
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int newWidth = _width;
        int newHeight = _height;
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    /**
     * @param bitmap
     * @return
     */
    public static Bitmap setBitmapSize(String bitmapPath) {
        Bitmap bitmap = BitmapFactory.decodeFile(bitmapPath);
        if (bitmap == null) {
//            Logger.i("bitmap", "bitmap------------>发生未知异常！");
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int newWidth = width;
        int newHeight = height;
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }
}
