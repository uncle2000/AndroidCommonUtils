package com.uncle2000.androidcommonutils.uitls.image;

import android.graphics.Bitmap;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.bitmap;

/**
 * Created by 2000 on 2017/4/10.
 */

public class ImageSplitter {

    /**
     * 将图片切成 , piece *piece
     *
     * @param bitmap
     * @param piece
     * @return
     */
    public List<ImagePiece> split(Bitmap bitmap, int piece) {

        List<ImagePiece> pieces = new ArrayList<ImagePiece>(piece * piece);

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        Log.e("TAG", "bitmap Width = " + width + " , height = " + height);
        int pieceWidth = Math.min(width, height) / piece;

        for (int i = 0; i < piece; i++) {
            for (int j = 0; j < piece; j++) {
                ImagePiece imagePiece = new ImagePiece();
                imagePiece.index = j + i * piece;
                int xValue = j * pieceWidth;
                int yValue = i * pieceWidth;

                imagePiece.bitmap = Bitmap.createBitmap(bitmap, xValue, yValue,
                        pieceWidth, pieceWidth);
                pieces.add(imagePiece);
            }
        }
        return pieces;
    }

    public class ImagePiece {
        public int index = 0;
        public Bitmap bitmap = null;
    }
}
//    private void initBitmap()
//    {
//        if (mBitmap == null)
//            mBitmap = BitmapFactory.decodeResource(getResources(),
//                    R.drawable.aa);
//
//        List<ImagePiece> mItemBitmaps = ImageSplitter.split(mBitmap, mColumn);
//
//        Collections.sort(mItemBitmaps, new Comparator<ImagePiece>()
//        {
//            @Override
//            public int compare(ImagePiece lhs, ImagePiece rhs)
//            {
//                return Math.random() > 0.5 ? 1 : -1;
//            }
//        });
//    }