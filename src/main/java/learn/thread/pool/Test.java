package learn.thread.pool;

import java.util.concurrent.ForkJoinPool;

public class Test {

    public static void main(String[] args) throws InterruptedException{
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(new MyRecursiveAction(1,10));
        Thread.sleep(5000);
    }
}
