package learn.thread.lock.readWriteLock;



import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * 人数到了才开始干活
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        Boss boss = new Boss(reentrantReadWriteLock);

        Worker w1 = new Worker(reentrantReadWriteLock,"张三");
        Worker w2 = new Worker(reentrantReadWriteLock,"李四");
        Worker w3 = new Worker(reentrantReadWriteLock,"王二");

        Worker w4 = new Worker(reentrantReadWriteLock,"赵六");
        Worker w5 = new Worker(reentrantReadWriteLock,"张杰");
        Worker w6 = new Worker(reentrantReadWriteLock,"王强");


        executor.execute(w1);
        executor.execute(w2);
        executor.execute(w3);
        executor.execute(boss);
        executor.execute(boss);
        executor.execute(boss);
        executor.execute(w4);
        executor.execute(w5);
        executor.execute(w6);


        executor.shutdown();


    }
}
