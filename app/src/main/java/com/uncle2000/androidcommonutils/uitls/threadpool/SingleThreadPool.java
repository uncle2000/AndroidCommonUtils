package com.uncle2000.androidcommonutils.uitls.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SingleThreadPool {
    private static ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

    private static SingleThreadPool instance = null;

    public static SingleThreadPool getInstance() {
        if (instance == null) {
            instance = new SingleThreadPool();
        }
        return instance;
    }

    public static void shutdown() {
        if (singleThreadExecutor != null) {
            singleThreadExecutor.shutdown();
        }
    }

    public static void shutdownRightnow() {
        if (singleThreadExecutor != null) {
            singleThreadExecutor.shutdownNow();
            try {
                // 设置超时极短，强制关闭所有任务
                singleThreadExecutor.awaitTermination(1, TimeUnit.MICROSECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized boolean addTask(Runnable task) {
        if (task != null) {
            singleThreadExecutor.execute(task);
            return true;
        }
        return false;
    }
//	public synchronized boolean addTask(AsyncSocketTask task){
//		if (task != null ) {
//			singleThreadExecutor.execute(task);
//			return true;
//		}
//		return false;
//	}
//    public synchronized boolean addTask(AsyncUrlConnectionPost task){
//        if (task != null ) {
//            singleThreadExecutor.execute(task);
//            return true;
//        }
//        return false;
//    }
}
