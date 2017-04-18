package com.uncle2000.androidcommonutils.uitls.image;


import java.lang.ref.SoftReference;
import java.util.Hashtable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader.TileMode;
import android.support.v4.util.LruCache;
import android.util.Log;

import com.uncle2000.androidcommonutils.R;
import com.uncle2000.androidcommonutils.uitls.SoftMap;

/**
 * @author chenlin
 * @version 1.0
 * @描述 图片处理工具
 * @项目名称 App_imooc
 * @包名 com.android.imooc.gallery
 * @类名 ImageUtil
 * @date 2012年9月5日 下午10:05:38
 */

public class ImageUtil {

    private static final String TAG = "ImageUtil";
    // --方式1 lrucache-------------------------------------------------

    private static LruCache<Integer, Bitmap> mCache;

    static {
        if (mCache == null) {
            // 最大使用的内存空间
            int maxSize = (int) (Runtime.getRuntime().freeMemory() / 4);
            mCache = new LruCache<Integer, Bitmap>(maxSize) {
                @Override
                protected int sizeOf(Integer key, Bitmap value) {
                    return value.getRowBytes() * value.getHeight();
                }
            };
        }
    }

    /**
     * 使用softmap获取缓存图片
     *
     * @param context
     * @param resId
     * @return
     */
    public static Bitmap getBitmapByLruCache(Context context, int resId) {
        Bitmap bitmap = mCache.get(resId);
        if (bitmap != null) {
            return bitmap;
        }
        bitmap = getReverseBitmapById(context, resId);
        mCache.put(resId, bitmap);
        return bitmap;
    }

    // --方式2 SoftMap-------------------------------------------------

    private static SoftMap<Integer, Bitmap> map = new SoftMap<Integer, Bitmap>();

    /**
     * 使用softmap获取缓存图片
     *
     * @param context
     * @param resId
     * @return
     */
    public static Bitmap getBitmapBySoftCache(Context context, int resId) {
        Bitmap bitmap = map.get(resId);
        if (bitmap != null) {
            return bitmap;
        }
        bitmap = getReverseBitmapById(context, resId);
        map.put(resId, bitmap);
        return bitmap;
    }

    // ---方式3--------------------------------
    // 缓存集合
    private static Hashtable<Integer, SoftReference<Bitmap>> mCacheHashTable = new Hashtable<Integer, SoftReference<Bitmap>>();

    /**
     * 根据id返回一个处理后的图片
     *
     * @param res
     * @param imageID
     * @return
     */
    public static Bitmap getImageBitmap(Context context, int imageID) {

        // 先去集合中取当前imageID 是否已经拿过图片, 如果集合中有, 说明已经拿过, 直接使用集合中的图片返回
        SoftReference<Bitmap> softReference = mCacheHashTable.get(imageID);
        if (softReference != null) {
            Bitmap bitmap = softReference.get();

            if (bitmap != null) {
                // 从内存中取
                Log.i(TAG, "从内存中取");
                return bitmap;
            }
        }

        // 如果集合中没有, 就调用getInvertImage得到一个图片, 需要向集合中保留一张, 最后返回当前图片
        Log.i(TAG, "重新加载");
        Bitmap invertImage = getReverseBitmapById(context, imageID);
        // 在集合中存一份, 便于下次再取的时候直接去集合中取.
        mCacheHashTable.put(imageID, new SoftReference<Bitmap>(invertImage));

        return invertImage;
    }

    /**
     * 根据图片id获得有倒影的图片
     *
     * @param resId
     * @return
     */
    public static Bitmap getReverseBitmapById(Context context, int resId) {
        int padding = context.getResources().getDimensionPixelOffset(0/*R.dimen.image_paddding*/);// 图片的间距//><
        // 绘制原图
        Bitmap sourceBitmap = BitmapFactory.decodeResource(context.getResources(), resId);

        // 图片的默认矩阵
        // float[] values = {
        // 1.0f, 0f, 0f,
        // 0f, 1.0f, 0f,
        // 0f, 0f, 1.0f
        // };

        // 绘制原图的下一半图片
        Matrix matrix = new Matrix();
        matrix.setScale(1, -1);
        // matrix.setValues(values);
        Bitmap inverseBitmap = Bitmap.createBitmap(sourceBitmap, 0, sourceBitmap.getHeight() / 2,
                sourceBitmap.getWidth(), sourceBitmap.getHeight() / 2, matrix, false);

        // 合成图片
        Bitmap groupbBitmap = Bitmap.createBitmap(sourceBitmap.getWidth(),
                sourceBitmap.getHeight() + sourceBitmap.getHeight() / 2 + padding, sourceBitmap.getConfig());

        Canvas gCanvas = new Canvas(groupbBitmap);
        // 把原图画在合成图片的上面
        gCanvas.drawBitmap(sourceBitmap, 0, 0, null);
        // 以图片的左上角与坐标
        gCanvas.drawBitmap(inverseBitmap, 0, sourceBitmap.getHeight() + padding, null);

        // 添加遮罩
        Paint paint = new Paint();
        TileMode tile = TileMode.CLAMP;
        LinearGradient shader = new LinearGradient(0, sourceBitmap.getHeight() + padding, 0, groupbBitmap.getHeight(),
                0x70ffffff, Color.TRANSPARENT, tile);
        paint.setShader(shader);

        paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));

        gCanvas.drawRect(0, sourceBitmap.getHeight() + padding, sourceBitmap.getWidth(), groupbBitmap.getHeight(),
                paint);

        return groupbBitmap;
    }

}