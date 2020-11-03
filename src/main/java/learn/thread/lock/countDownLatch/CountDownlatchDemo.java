package learn.thread.lock.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 老板等三个工人完成任务后才去检查工作
 */
public class CountDownlatchDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        CountDownLatch latch = new CountDownLatch(3);

        Worker w1 = new Worker(latch,"张三");
        Worker w2 = new Worker(latch,"李四");
        Worker w3 = new Worker(latch,"王二");

        Boss boss = new Boss(latch);

        executor.execute(w1);
        executor.execute(w2);
        executor.execute(w3);
        executor.execute(boss);

        executor.shutdown();


    }
}
