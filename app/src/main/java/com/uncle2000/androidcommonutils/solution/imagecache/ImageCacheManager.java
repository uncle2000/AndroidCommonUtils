package com.uncle2000.androidcommonutils.solution.imagecache;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;

import com.uncle2000.androidcommonutils.uitls.threadpool.DefaultThreadPool;

import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;


public class ImageCacheManager {
    	public enum Type{
		FIFO, LIFO
	}
	private Semaphore mSemaphoreThreadPool;
	private ExecutorService mThreadPool;
	private LinkedList<Runnable> mTaskQueue;
	private Thread mPoolThread;
	private Handler mPoolThreadHandler;
	private Semaphore mSemaphorePoolThreadHandler = new Semaphore(0);
    protected DefaultThreadPool HTTP_TASK_MANAGER = DefaultThreadPool.getInstance();
    Set<String> urlList = new HashSet<>();
    boolean stik = false;
    //	public static final int COMPRESS_MODEL = 0;//
//    private ImageMemeryCache mMemeryCaches;//图片缓存处理解决方法
    //	private OnImgCacheReady imgCacheReady;//图片缓存是否准备好
//    private Context mContext;
//	private Type mType = Type.FIFO;
//	private Runnable getTask()
//	{
//		if (mType == Type.FIFO)
//		{
//			return mTaskQueue.removeFirst();
//		} else if (mType == Type.LIFO)
//		{
//			return mTaskQueue.removeLast();
//		}
//		return null;
//	}
//	private void cacheReady() {
//		synchronized (imgCacheReady) {
//			imgCacheReady.cacheIsReady();
//		}
//	}
    /**
     * 获取图片的缓存
     *
     * @return
     */
//	private class ImgBeanHolder
//	{
////		Bitmap bitmap;
//		ImageView imageView;
//		String path;
//	}
//	private Handler mUIHandler;

//    private CacheTimeCount cacheTimeCount;

//	private void downloadImage(String tag) {
//		ImgDownloadTask task = new ImgDownloadTask(new ImgDownloadTaskHandler() {
//			@Override
//			public void taskResult(int status, String message, String tag_str, Bitmap bmp) {
//				if (status == SuperTaskHandler.SUCCESS && bmp != null) {
//					mMemeryCaches.addBitmapToCache(tag_str, bmp);
//				}
//			}
//
//			@Override
//			public void progress(int progress) {
//			}
//
//			@Override
//			public void notifyView() {
//				cacheReady();
//			}
//		}, tag, false);
//		DownloadTaskManager.addTask(task,"POST");
//	}

//    public ImageCacheManager(Context context, OnImgCacheReady onImgCacheReady) {
//        this.mMemeryCaches = ImageMemeryCache.getInstance();
////		this.imgCacheReady = onImgCacheReady;
////        this.mContext = context;
////        cacheTimeCount = new CacheTimeCount(1000 * 60 * 60 * 72, 500);
////        cacheTimeCount.start();
//    }

    /**
     * 获得缓存图片的地址
     *
     * @param context
     * @return
     */
    public static File getDiskCacheFileName(Context context, String url) {

        String uniqueName = ImageMemeryCache.md5(url);
        String cachePath;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            cachePath = context.getExternalCacheDir().getPath();
        } else {
            cachePath = context.getCacheDir().getPath();
        }
        return new File(cachePath + File.separator + uniqueName);
    }

//    public static void copyToCacheDir(String file, String url) {
//        File cacheFileName = getDiskCacheFileName(VApplication.getInstance(), url);
//        FileUtils.copyFile(file, cacheFileName.getAbsolutePath(), false);
//    }


    private synchronized void addTask(Runnable runnable) {
        HTTP_TASK_MANAGER.addTask(runnable);
//		mTaskQueue.add(runnable);
//		// if(mPoolThreadHandler==null)wait();
//		try
//		{
//			if (mPoolThreadHandler == null)
//				mSemaphorePoolThreadHandler.acquire();
//		} catch (InterruptedException e)
//		{
//		}
//		mPoolThreadHandler.sendEmptyMessage(0x110);
    }

//    public Bitmap getCache(String tag) {
//        if (null == mMemeryCaches || null == mMemeryCaches.getBitmapFromCache(tag) || mMemeryCaches.getBitmapFromCache(tag).isRecycled())
//            return null;
//        return mMemeryCaches.getBitmapFromCache(tag);
//    }
//
//    public void addImageCache(String url, Bitmap bitmap) {
//        mMemeryCaches.addBitmapToCache(url, bitmap);
//    }

//    public void getImageCache(ImageView iv, final String tag, boolean download, boolean reLoad, int defaultDrawable, int compressModel, DownCallBack callBack) {
//        getImageCache(iv, null, tag, download, reLoad, defaultDrawable, compressModel, -1, callBack);
//    }
//
//    public void getImageCache(ImageView iv, TextView tv, final String tag, boolean download, boolean reLoad, int defaultDrawable, int compressModel, DownCallBack callBack) {
//        getImageCache(iv, tv, tag, download, reLoad, defaultDrawable, compressModel, -1, callBack);
//    }
//
//    public void getImageCache(ImageView iv, final String tag, boolean download, boolean reLoad, int defaultDrawable, int compressModel, int compressLimit, DownCallBack callBack) {
//        getImageCache(iv, null, tag, download, reLoad, defaultDrawable, compressModel, compressLimit, callBack);
//    }

    /**
     * @param iv
     * @param tv
     * @param tag
     * @param download
     * @param reLoad
     * @param defaultDrawable
     * @param compressModel   1
     * @param compressLimit   40*1024
     * @param callBack
     */
//    public void getImageCache(ImageView iv, TextView tv, final String tag, boolean download, boolean reLoad, int defaultDrawable, int compressModel, int compressLimit, DownCallBack callBack) {
////		if(stik){
////			stik=false;
////			return;
////		}
//        TaskHandler UIHandler;
//        if (tag == null) {
//            iv.setImageBitmap(getAppImgCache(defaultDrawable));
//            return;
//        }
//        if (reLoad)
//            mMemeryCaches.delBitmapToCache(tag);
//        final Bitmap bmp = getCache(tag);
//        if (bmp == null) {
//            if (urlList.contains(tag)) {
//                iv.setImageBitmap(getAppImgCache(defaultDrawable));
//                return;
//            }
//            urlList.add(tag);
//            iv.setImageBitmap(getAppImgCache(defaultDrawable));
////			if(null!=UIHandler) {
////			}else{
//            UIHandler = new TaskHandler(Looper.getMainLooper());
//            UIHandler.setCallBack(callBack);
//            UIHandler.setUrl(tag);
//            UIHandler.setIv(iv);
//            UIHandler.setTv(tv);
////			}
//            if (tag.contains("http")) {
//                if (download) {
//                    addTask(buildTask(tag, iv, tv, true, compressModel, compressLimit, UIHandler));
//                }
//            } else {
//                addTask(buildTask(tag, iv, tv, false, compressModel, compressLimit, UIHandler));
//            }
//        } else {
//            if(callBack != null){
//                callBack.NotifyView(iv,tag,tag);
//            }
//            iv.setImageBitmap(getCache(tag));
//        }
//    }
    /**
     * 利用签名辅助类，将字符串字节数组
     *
     * @param str
     * @return
     */

//    private Runnable buildTask(final String key, final ImageView imageView, final TextView tv, final boolean isFromNet, final int compressModel, final int compressLimit, final TaskHandler UIHandler) {
//        return new Runnable() {
//            @Override
//            public void run() {
//                Bitmap bm = null;
//                if (isFromNet) {
//                    File file = getDiskCacheFileName(imageView.getContext(), key);
//                    if (file.exists()) {
//                        if (compressModel == 0)
//                            bm = BitmapUtil.loadImageFromLocal(file.getAbsolutePath(), imageView);
//                        else
//                            bm = BitmapUtil.getLocalFileImageBitmap(file.getAbsolutePath(), -1);
//                        addImageCache(key, bm);
//                        if (null != UIHandler)
//                            UIHandler.notifyViewChange();
//                    } else {
//                        boolean downloadState = DownloadImgUtils.downloadImgByUrl(tv, key.replaceFirst(Constant.LruCachePrefix, ""), file, UIHandler);
//                        if (downloadState) {
//                            if (compressModel == 0)
//                                bm = BitmapUtil.loadImageFromLocal(file.getAbsolutePath(), imageView);
//                            else
//                                bm = BitmapUtil.getLocalFileImageBitmap(file.getAbsolutePath(), compressLimit);
//                        }
//                        addImageCache(key, bm);
//                        if (null != UIHandler) {
//                            UIHandler.notifyViewChange();
//                        }
//                    }
//                } else {
//                    if (compressModel == 0) {
//                        bm = BitmapUtil.loadImageFromLocal(key.replaceFirst(Constant.LruCachePrefix, ""), imageView);
//                    } else {
//                        bm = BitmapUtil.getLocalFileImageBitmap(key.replaceFirst(Constant.LruCachePrefix, ""), compressLimit);
//                    }
//                    addImageCache(key, bm);
//                    if (null != UIHandler)
//                        UIHandler.notifyViewChange();
//                }
//                urlList.remove(key);
////				refreashBitmap(path, imageView);
////				mSemaphoreThreadPool.release();
//            }
//        };
//    }
//
//    public Bitmap getAppImgCache(int resId) {
//        if (resId == -1)
//            return null;
//        Bitmap bitmap = mMemeryCaches.getBitmapFromCache(String.valueOf(resId));
//        if (bitmap == null) {
//            bitmap = BitmapFactory.decodeResource(VApplication.getInstance().getResources(), resId).copy(Config.ARGB_8888, true);
//            mMemeryCaches.addBitmapToCache(String.valueOf(resId), bitmap);
//        }
//        return bitmap;
//    }
//
////	private void refreashBitmap(final String path, final ImageView imageView){
////		Message message = Message.obtain();
////		ImgBeanHolder holder = new ImgBeanHolder();
//////		holder.bitmap = bm;
////		holder.path = path;
////		holder.imageView = imageView;
////		message.obj = holder;
////		mUIHandler.sendMessage(message);
////	}
//
//    public void delCache(String key) {
//        mMemeryCaches.delBitmapToCache(key);
//    }
//
//    public interface OnImgCacheReady {
//        public void cacheIsReady();
//    }
//
//    class CacheTimeCount extends CountDownTimer {
//        public CacheTimeCount(long millisInFuture, long countDownInterval) {
//            super(millisInFuture, countDownInterval);
//        }
//
//        @Override
//        public void onTick(long millisUntilFinished) {
//            stik = true;
//        }
//
//        @Override
//        public void onFinish() {
//
//        }
//    }

//	private void waitsec(){
//		final Timer timer = new Timer();
//	    final Handler handler = new Handler(){
//	        public void handleMessage(Message msg) {
//	            switch (msg.what) {
//	            case 1:
//	            	timer.cancel(); //退出计时器
//	                break;
//	            }
//	            super.handleMessage(msg);
//	        }
//	        };
//	    TimerTask task = new TimerTask(){
//	        public void run() {
//	            Message message = new Message();
//	            message.what = 1;
//	            handler.sendMessage(message);
//	        }
//	    };
//	    timer.schedule(task, 1200);
//	}


}
