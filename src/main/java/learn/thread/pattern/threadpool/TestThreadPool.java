package learn.thread.pattern.threadpool;

import java.util.concurrent.ExecutorService;

public class TestThreadPool {

    public static void main(String[] args) {
        ExecutorService threadPool = SingletonThreadPool.getInstance().getThreadPool();
        ExecutorService threadPool1 = SingletonThreadPool.getInstance().getThreadPool();
        ExecutorService threadPool12= SingletonThreadPool.getInstance().getThreadPool();
        System.out.println(threadPool == threadPool1);
        System.out.println(threadPool == threadPool12);

        threadPool.execute(new workThread("吃饭"));
        threadPool.execute(new workThread("拉屎"));
    }

}
