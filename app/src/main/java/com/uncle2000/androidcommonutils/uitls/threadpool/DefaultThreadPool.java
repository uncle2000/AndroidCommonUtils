package com.uncle2000.androidcommonutils.uitls.threadpool;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/***
 * @function 线程池
 */
public class DefaultThreadPool {
    /**
     * 用于保存等待执行的任务的阻塞队列。(有序的先进先出阻塞队列)
     */
    private static ArrayBlockingQueue<Runnable> mBlockingQueue = new ArrayBlockingQueue<Runnable>(15, true);
    //    private static ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
    public static AbstractExecutorService mThreadPoolExecutor
            = new ThreadPoolExecutor(5, 7, 25, TimeUnit.SECONDS, mBlockingQueue,
            new ThreadPoolExecutor.DiscardOldestPolicy());

    private static DefaultThreadPool instance = null;

    public static DefaultThreadPool getInstance() {
        if (instance == null) {
            instance = new DefaultThreadPool();
        }
        return instance;
    }

//    public void execute(Runnable r) {
//        mThreadPoolExecutor.execute(r);
//    }

    /**
     * 关闭，并等待任务执行完成，不接受新任务
     */
    public static void shutdown() {
        if (mThreadPoolExecutor != null) {
            mThreadPoolExecutor.shutdown();
        }
    }

    /**
     * 关闭，立即关闭，并挂起所有正在执行的线程，不接受新任务
     */
    public static void shutdownRightnow() {
        if (mThreadPoolExecutor != null) {
            mThreadPoolExecutor.shutdownNow();
            try {
                // 设置超时极短，强制关闭所有任务
                mThreadPoolExecutor.awaitTermination(1, TimeUnit.MICROSECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized boolean addTask(Runnable task) {
        if (task != null) {
            mThreadPoolExecutor.execute(task);
            return true;
        }
        return false;
    }
//	public synchronized boolean addTask(AsyncSocketTask task){
//		if (task != null) {
//			mThreadPoolExecutor.execute(task);
//			return true;
//		}
//		return false;
//	}
//    public synchronized boolean addTask(AsyncUrlConnectionPost task){
//        if (task != null) {
//            mThreadPoolExecutor.execute(task);
//            return true;
//        }
//        return false;
//    }
}
