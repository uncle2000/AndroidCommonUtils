package com.uncle2000.androidcommonutils.solution.imagecache;

import android.graphics.Bitmap;
import android.util.LruCache;

import java.lang.ref.SoftReference;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;

public class ImageMemeryCache {
    private static final int SOFT_CACHE_SIZE = 16;
    private static LruCache<String, Bitmap> mHardCache = null;
    private static LinkedHashMap<String, SoftReference<Bitmap>> mSoftCache = null;

    private static ImageMemeryCache instance;

    public static synchronized ImageMemeryCache getInstance() {
        if (instance == null) {
            synchronized (ImageMemeryCache.class) {
                if (instance == null)
                    instance = new ImageMemeryCache();
            }
        }
        return instance;
    }

    public ImageMemeryCache() {
        if (mHardCache == null) {
//            int memClass = ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE)).getMemoryClass();
//			int cacheSize = 1024 * 1024 * memClass / 8;
            mHardCache = new LruCache<String, Bitmap>(1024 * 1024 * 8) {
                @Override
                protected void entryRemoved(boolean evicted, String key, Bitmap oldValue, Bitmap newValue) {
                    if (oldValue != null) {
                        mSoftCache.put(key, new SoftReference<Bitmap>(oldValue));
                    }
                }

                @Override
                protected int sizeOf(String key, Bitmap value) {
                    if (value != null) {
                        return value.getRowBytes() * value.getHeight();
                    } else {
                        return 0;
                    }
                }
            };
        }
        if (mSoftCache == null) {
            mSoftCache = new LinkedHashMap<String, SoftReference<Bitmap>>(SOFT_CACHE_SIZE, 0.75f, true) {
                private static final long serialVersionUID = 6040103833179403725L;

                @Override
                protected boolean removeEldestEntry(Entry<String, SoftReference<Bitmap>> eldest) {
                    if (size() > SOFT_CACHE_SIZE) {
                        return true;
                    }
                    return false;
                }
            };
        }
    }

    /**
     * 添加图片到缓存
     */
    public static void addBitmapToCache(String key, Bitmap bitmap) {
        if (null == mHardCache)
            return;
        if (bitmap != null) {
            synchronized (mHardCache) {
                mHardCache.put(md5(key), bitmap);
            }
        }
    }

    public static String md5(String str) {
        byte[] digest = null;
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            digest = md.digest(str.getBytes());
            return bytes2hex02(digest);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String bytes2hex02(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        String tmp = null;
        for (byte b : bytes) {
            // 将每个字节与0xFF进行与运算，然后转化为10进制，然后借助于Integer再转化为16进制
            tmp = Integer.toHexString(0xFF & b);
            if (tmp.length() == 1)// 每个字节8为，转为16进制标志，2个16进制位
            {
                tmp = "0" + tmp;
            }
            sb.append(tmp);
        }
        return sb.toString();

    }

    public static void clearCache() {
        if (mHardCache != null) {
            mHardCache.evictAll();
            mHardCache = null;
        }
        if (mSoftCache != null) {
            mSoftCache.clear();
            mSoftCache = null;
        }
        System.gc();
    }

    /**
     * 从缓存中获取图片
     */
    public Bitmap getBitmapFromCache(String tag) {
        String key = md5(tag);
        Bitmap bitmap;
        // 先从硬引用缓存中获取
        try {
            synchronized (mHardCache) {
                bitmap = mHardCache.get(key);
                if (bitmap.isRecycled()) {
                    mHardCache.remove(key);
                    bitmap = null;
                }
                if (bitmap != null) {
                    // 如果找到的话，把元素移到LinkedHashMap的最前面，从而保证在LRU算法中是最后被删除
                    mHardCache.remove(key);
                    mHardCache.put(key, bitmap);
                    return bitmap;
                }
            }
            // 如果硬引用缓存中找不到，到软引用缓存中找
            synchronized (mSoftCache) {
                SoftReference<Bitmap> bitmapReference = mSoftCache.get(key);
                if (bitmapReference != null) {
                    bitmap = bitmapReference.get();
                    if (bitmap.isRecycled()) {
                        mSoftCache.remove(key);
                        bitmap = null;
                    }
                    if (bitmap != null) {
                        // 将图片移回硬缓存
                        mHardCache.put(key, bitmap);
                        mSoftCache.remove(key);
                        return bitmap;
                    } else {
                        mSoftCache.remove(key);
                    }
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void delBitmapToCache(String url) {
        Bitmap bitmap;
        synchronized (mHardCache) {
            bitmap = mHardCache.get(url);
            if (bitmap != null) {
                mHardCache.remove(url);
            } else {
                mSoftCache.remove(url);
            }
        }
        System.gc();
    }

}
