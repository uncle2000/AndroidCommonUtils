package com.uncle2000.androidcommonutils.uitls.equipment.storage;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.format.Formatter;

import java.io.File;

/**
 * Created by 2000 on 2017/4/10.
 */

public class SDCard {

    /**
     * SD卡
     *
     * @param context
     */
    @TargetApi(18)
    public static void getSDCardInfo(Context context) {
        try {
            File path = Environment.getExternalStorageDirectory();
            StatFs s = new StatFs(path.getPath());
            long availableBlocks = s.getAvailableBlocksLong();
            long blockCount = s.getBlockCountLong();
            long blockSize = s.getBlockSizeLong();

            long totalsize = blockSize * blockCount;
            long availsize = blockSize * availableBlocks;

            String totalsizeStr = Formatter.formatFileSize(context, totalsize);
            String availsizeStr = Formatter.formatFileSize(context, availsize);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    /**
//     * 获取手机外部可用空间大小
//     *
//     * @return
//     */
//    @SuppressWarnings("deprecation")
//    public static long getAvailableExternalMemorySize() {
//        if (externalMemoryAvailable()) {
//            File path = Environment.getExternalStorageDirectory();
//            StatFs stat = new StatFs(path.getPath());
//            long blockSize = stat.getBlockSize();
//            long availableBlocks = stat.getAvailableBlocks();
//            return availableBlocks * blockSize;
//        } else {
//            throw new RuntimeException("Don't have sdcard.");
//        }
//    }
//
//    /**
//     * 获取手机外部空间大小
//     *
//     * @return
//     */
//    @SuppressWarnings("deprecation")
//    public static long getTotalExternalMemorySize() {
//        if (externalMemoryAvailable()) {
//            File path = Environment.getExternalStorageDirectory();// 获取外部存储目录即 SDCard
//            StatFs stat = new StatFs(path.getPath());
//            long blockSize = stat.getBlockSize();
//            long totalBlocks = stat.getBlockCount();
//            return totalBlocks * blockSize;
//        } else {
//            throw new RuntimeException("Don't have sdcard.");
//        }
//    }
//
//    /**
//     * 外部存储是否可用
//     *
//     * @return
//     */
//    public static boolean externalMemoryAvailable() {
//        return android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
//    }

}