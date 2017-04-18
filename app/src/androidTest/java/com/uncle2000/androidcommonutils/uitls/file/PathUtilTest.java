package com.uncle2000.androidcommonutils.uitls.file;

import android.content.Context;
import android.test.AndroidTestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 2000 on 2017/4/18.
 */
public class PathUtilTest extends AndroidTestCase {
    private PathUtil pathUtil;

    @Before
    public void setUp() throws Exception {
        System.out.println("==>" + getContext().getPackageName());
        pathUtil = new PathUtil(getContext());
    }

    @Test
    public void getLogPath() throws Exception {
        System.out.println("==>" + pathUtil.getLogPath());
    }

    @Test
    public void getCachePath() throws Exception {
        System.out.println("==>" + pathUtil.getCachePath());
    }

    @Test
    public void getFilesPath() throws Exception {
        System.out.println("==>" + pathUtil.getFilesPath());
    }

    @Test
    public void isSdCardExitOrCouldWrite() throws Exception {
        System.out.println("==>" + pathUtil.isSdCardExitOrCouldWrite());
    }
}