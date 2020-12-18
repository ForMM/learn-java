package learn.thread.lock.readWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Boss implements Runnable {

    private ReentrantReadWriteLock reentrantReadWriteLock;

    public Boss(ReentrantReadWriteLock reentrantReadWriteLock) {
        this.reentrantReadWriteLock = reentrantReadWriteLock;
    }

    public void run() {
        try {

            this.reentrantReadWriteLock.writeLock().lock();
            System.out.println("老板开始写文件");
            this.writeFile();
            System.out.println("老板写完了文件");
        } catch (Exception e) {
        }finally {
            this.reentrantReadWriteLock.writeLock().unlock();
        }
    }

    public void writeFile(){
        System.out.println("正在写文件");
    }
}
