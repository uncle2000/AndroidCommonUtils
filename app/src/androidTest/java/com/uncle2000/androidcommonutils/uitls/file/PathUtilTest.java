package com.uncle2000.androidcommonutils.uitls.file;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 2000 on 2017/4/14.
 */
public class PathUtilTest {
    @Test
    public void getDir() throws Exception {

    }

    @Test
    public void getCacheDir() throws Exception {
        System.out.println("==>" + PathUtil.getCacheDir());
    }

    @Test
    public void getIconDir() throws Exception {
        System.out.println("==>" + PathUtil.getIconDir());
    }

}