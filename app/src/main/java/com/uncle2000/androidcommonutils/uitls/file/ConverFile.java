package com.uncle2000.androidcommonutils.uitls.file;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by 2000 on 2017/4/14.
 */

public class ConverFile {

    /**
     * InputStream->byte[]
     *
     * @param in InputStream
     * @return byte[]
     * @throws IOException
     */
    public static byte[] InputStreamTOByte(InputStream in) throws IOException {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] data = new byte[6 * 1024];
        int count = -1;
        while ((count = in.read(data, 0, 4 * 1024)) != -1)
            outStream.write(data, 0, count);
        data = null;
        return outStream.toByteArray();
    }

    /**
     * OutputStream->byte[]
     *
     * @param in OutputStream
     * @return byte[]
     * @throws IOException
     */
    public static byte[] OutputStreamTOByte(OutputStream out)
            throws IOException {

        byte[] data = new byte[6 * 1024];
        out.write(data);
        return data;
    }

    /**
     * byte[]->InputStream
     *
     * @param in
     * @return
     * @throws Exception
     */
    public static InputStream byteTOInputStream(byte[] in) {
        ByteArrayInputStream is = new ByteArrayInputStream(in);
        return is;
    }

    /**
     * byte[]->OutputStream
     *
     * @param in
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static OutputStream byteTOOutputStream(byte[] in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write(in);
        return out;
    }
}
