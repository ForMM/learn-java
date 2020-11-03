package learn.thread.lock.cyclicBarries;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Worker implements Runnable {
    private CyclicBarrier cyclicBarrier;
    private String name;

    public Worker(CyclicBarrier cyclicBarrier, String name) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
    }

    public void run() {
        try {
            System.out.println(this.name+",来了");
            this.cyclicBarrier.await();
//            this.doWork();
        }catch (InterruptedException ie){

        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void doWork(){
        System.out.println("所有人都来了，我们开始干活");
    }
}
