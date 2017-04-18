package com.uncle2000.androidcommonutils.uitls.file;

import android.net.Uri;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by 2000 on 2017/4/14.
 */

public class ConverFile {

    /**
     * uri->path
     *
     * @param uri
     * @return
     */
    public static String uri2Path(Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.getPath();
    }

    /**
     * path->uri
     *
     * @param path
     * @return
     */
    public static Uri path2Uri(String path) {
        if (path == null) {
            return null;
        }
        File file = new File(path);
        if (file.exists() && (file.isFile() || file.isDirectory())) {
            return Uri.fromFile(file);
        }
        return null;
    }


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
     * @param out OutputStream
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

    /**
     * path->InputStream
     *
     * @param path
     * @return
     * @throws FileNotFoundException
     */
    public InputStream path2InputStream(String path) throws FileNotFoundException {
        FileInputStream filein = null;
        File file = new File(path);
        filein = new FileInputStream(file);
        BufferedInputStream in = null;
        if (filein != null)
            in = new BufferedInputStream(filein);
        return in;
    }

}
