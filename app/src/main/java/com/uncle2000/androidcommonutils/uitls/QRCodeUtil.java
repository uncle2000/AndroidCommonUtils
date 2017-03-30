package com.uncle2000.androidcommonutils.uitls;//package com.uncle2000.appcommonutils.uitls;
//
//import android.graphics.Bitmap;
//import android.graphics.Matrix;
//import android.widget.ImageView;
//
//import com.google.zxing.BarcodeFormat;
//import com.google.zxing.EncodeHintType;
//import com.google.zxing.WriterException;
//import com.google.zxing.common.BitMatrix;
//import com.google.zxing.qrcode.QRCodeWriter;
//import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
//import com.google.zxing.qrcode.encoder.ByteMatrix;
//import com.google.zxing.qrcode.encoder.Encoder;
//import com.google.zxing.qrcode.encoder.QRCode;
//
//import java.util.HashMap;
//import java.util.Hashtable;
//import java.util.Map;
//
///**
// * Created by xiao on 2017/1/18.
// * 功能:
// * 需求地址:
// */
//
//public class QRCodeUtil {
//
//    // 生成QR图
//    public static Bitmap createImage(String text, int w, int h, Bitmap logo) {
//        try {
//            Bitmap scaleLogo = getScaleLogo(logo, w, h);
//            int offsetX = (w - scaleLogo.getWidth()) / 2;
//            int offsetY = (h - scaleLogo.getHeight()) / 2;
//            Map<EncodeHintType, String> hints = new HashMap<>();
//            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
//            BitMatrix bitMatrix = new QRCodeWriter().encode(text,
//                    BarcodeFormat.QR_CODE, w, h, hints);
//            int[] pixels = new int[w * h];
//            for (int y = 0; y < h; y++) {
//                for (int x = 0; x < w; x++) {
//                    if (x >= offsetX && x < offsetX + scaleLogo.getWidth() && y >= offsetY && y < offsetY + scaleLogo.getHeight()) {
//                        int pixel = scaleLogo.getPixel(x - offsetX, y - offsetY);
//                        if (pixel == 0) {
//                            if (bitMatrix.get(x, y)) {
//                                pixel = 0xff000000;
//                            } else {
//                                pixel = 0xffffffff;
//                            }
//                        }
//                        pixels[y * w + x] = pixel;
//                    } else {
//                        if (bitMatrix.get(x, y)) {
//                            pixels[y * w + x] = 0xff000000;
//                        } else {
//                            pixels[y * w + x] = 0xffffffff;
//                        }
//                    }
//                }
//            }
//            Bitmap bitmap = Bitmap.createBitmap(w, h,
//                    Bitmap.Config.ARGB_8888);
//            bitmap.setPixels(pixels, 0, w, 0, 0, w, h);
//            return bitmap;
//        } catch (WriterException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    //Edited by mythou
//    //http://www.cnblogs.com/mythou/
//    //要转换的地址或字符串,可以是中文
//    public static void createQRImage(String url, ImageView imageView, int zoom) {
//        try {
//            //判断URL合法性
//            if (url == null || "".equals(url) || url.length() < 1) {
//                return;
//            }
//            Hashtable<EncodeHintType, Integer> hints = new Hashtable<EncodeHintType, Integer>();
////            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
////            hints.put(EncodeHintType.MARGIN, 0);
//            //图像数据转换，使用了矩阵转换
////            BitMatrix bitMatrix = new QRCodeWriter().encode(url, BarcodeFormat.QR_CODE, 0, 0, hints);
//
//
//            QRCode code = Encoder.encode(url, ErrorCorrectionLevel.L, null);
//
//            BitMatrix bitMatrix = renderResult(code, zoom);
//            int[] pixels = new int[bitMatrix.getWidth() * bitMatrix.getHeight()];
//            //下面这里按照二维码的算法，逐个生成二维码的图片，
//            //两个for循环是图片横列扫描的结果
//            for (int y = 0; y < bitMatrix.getHeight(); y++) {
//                for (int x = 0; x < bitMatrix.getWidth(); x++) {
//                    if (bitMatrix.get(x, y)) {
//                        pixels[y * bitMatrix.getWidth() + x] = 0xff000000;
//                    } else {
//                        pixels[y * bitMatrix.getWidth() + x] = 0xffffffff;
//                    }
//                }
//            }
//            //生成二维码图片的格式，使用ARGB_8888
//            Bitmap bitmap = Bitmap.createBitmap(bitMatrix.getWidth(), bitMatrix.getHeight(), Bitmap.Config.ARGB_8888);
//            bitmap.setPixels(pixels, 0, bitMatrix.getWidth(), 0, 0, bitMatrix.getWidth(), bitMatrix.getHeight() );
//            //显示到一个ImageView上面
//            imageView.setImageBitmap(bitmap);
//        } catch (WriterException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static BitMatrix renderResult(QRCode code, int zoom) {
//        ByteMatrix input = code.getMatrix();
//        if (input == null) {
//            throw new IllegalStateException();
//        }
//        int inputWidth = input.getWidth();
//        int inputHeight = input.getHeight();
//
//        BitMatrix output = new BitMatrix(inputWidth * zoom, inputHeight * zoom);
//
//        for (int inputY = 0, outputY = 0; inputY < inputHeight; inputY++, outputY += zoom) {
//            // Write the contents of this row of the barcode
//            for (int inputX = 0, outputX = 0; inputX < inputWidth; inputX++, outputX += zoom) {
//                if (input.get(inputX, inputY) == 1) {
//                    output.setRegion(outputX, outputY, zoom, zoom);
//                }
//            }
//        }
//
//        return output;
//    }
//
//    private static Bitmap getScaleLogo(Bitmap logo, int w, int h) {
//        if (logo == null) return null;
//        Matrix matrix = new Matrix();
//        float scaleFactor = Math.min(w * 1.0f / 5 / logo.getWidth(), h * 1.0f / 5 / logo.getHeight());
//        matrix.postScale(scaleFactor, scaleFactor);
//        Bitmap result = Bitmap.createBitmap(logo, 0, 0, logo.getWidth(), logo.getHeight(), matrix, true);
//        return result;
//    }
//
//
//}
