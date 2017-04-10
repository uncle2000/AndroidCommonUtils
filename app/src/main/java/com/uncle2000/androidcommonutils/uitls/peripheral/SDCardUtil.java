package com.uncle2000.androidcommonutils.uitls.peripheral;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.format.Formatter;

import java.io.File;

/**
 * Created by 2000 on 2017/4/10.
 */

public class SDCardUtil {

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