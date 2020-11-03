package learn.thread.lock.semaphore;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;




public class SemaphoreDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        Semaphore semaphore = new Semaphore(3);

        Worker w1 = new Worker(semaphore,"张三");
        Worker w2 = new Worker(semaphore,"李四");
        Worker w3 = new Worker(semaphore,"王二");
        Worker w4 = new Worker(semaphore,"赵六");
        Worker w5 = new Worker(semaphore,"张杰");
        Worker w6 = new Worker(semaphore,"王强");


        executor.execute(w1);
        executor.execute(w2);
        executor.execute(w3);
        executor.execute(w4);
        executor.execute(w5);
        executor.execute(w6);

        executor.shutdown();


    }
}
