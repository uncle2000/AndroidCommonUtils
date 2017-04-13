package com.uncle2000.androidcommonutils.uitls.equipment.storage;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.format.Formatter;
import android.util.Log;

import java.io.File;

/**
 * Created by 2000 on 2017/4/10.
 */

public class Memory {
    private static final String TAG = "Memory";
    private static final int MAXMEMORY = 300 * 1024 * 1024;//程序运行的最大内存 模拟器(0-16m)

    /**
     * 判断系统是否在低内存下运行
     *
     * @param context
     * @return
     */
    public static boolean hasAcailMemory() {
        // 获取手机内部空间大小
        long memory = getAvailableInternalMemorySize();
        Log.i(TAG, memory + "");
        if (memory < MAXMEMORY) {
            //应用将处于低内存状态下运行
            return false;
        } else {
            return true;
        }
    }

    /**
     * 获取手机内部可用空间大小
     *
     * @return
     */
    @SuppressWarnings("deprecation")
    public static long getAvailableInternalMemorySize() {
        File path = Environment.getDataDirectory();// 获取 Android 数据目录
        StatFs stat = new StatFs(path.getPath());// 一个模拟linux的df命令的一个类,获得SD卡和手机内存的使用情况
        long blockSize = stat.getBlockSize();// 返回 Int ，大小，以字节为单位，一个文件系统
        long availableBlocks = stat.getAvailableBlocks();// 返回 Int ，获取当前可用的存储空间
        return availableBlocks * blockSize;
    }

    /**
     * 获取手机内部空间大小
     *
     * @return
     */
    @SuppressWarnings("deprecation")
    public static long getTotalInternalMemorySize() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long totalBlocks = stat.getBlockCount();// 获取该区域可用的文件系统数
        return totalBlocks * blockSize;
    }
    /**
     * 手机内存
     *
     * @param context
     */

    @TargetApi(18)
    public static void getDataInfo(Context context) {
        try {
            File path = Environment.getDataDirectory();
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
}
