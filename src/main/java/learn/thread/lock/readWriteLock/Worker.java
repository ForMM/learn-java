package learn.thread.lock.readWriteLock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Worker implements Runnable {
    private ReentrantReadWriteLock reentrantReadWriteLock;
    private String name;

    public Worker(ReentrantReadWriteLock reentrantReadWriteLock, String name) {
        this.reentrantReadWriteLock = reentrantReadWriteLock;
        this.name = name;
    }

    public void run() {
        try {
            System.out.println(this.name+",开始阅读文件");
            this.reentrantReadWriteLock.readLock().lock();
            this.readFile();
            System.out.println(this.name+",阅读文件结束");
        }catch (Exception ie){

        }finally {
            this.reentrantReadWriteLock.readLock().unlock();
        }
    }

    public void readFile(){
        System.out.println(this.name+",正在读文件");
    }

}
