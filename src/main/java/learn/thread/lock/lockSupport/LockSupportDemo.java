package learn.thread.lock.lockSupport;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * 实现一个容器，提供两个方法 add,size ，写两个线程：
 * 线程1，添加10个元素到容器中
 * 线程2，实时监控元素个数，当元素个数到5个时，线程2给出提示并结束
 */
public class LockSupportDemo {
    volatile List lists = new ArrayList();
    public void add(Object o) {
        lists.add(o);
    }
    public int size() {
        return lists.size();
    }

    static Thread t1,t2;

    public static void main(String[] args) {
        final LockSupportDemo lockSupportDemo = new LockSupportDemo();

        t1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("开始添加数据到容器");
                for (int i=0;i<10;i++){
                    lockSupportDemo.add(new Object());
                    System.out.println("add "+i);

                    if (lockSupportDemo.size() == 5){
                        LockSupport.unpark(t2);
                        LockSupport.park();
                    }

                }
            }
        });

        t2 = new Thread(new Runnable() {
            public void run() {
                System.out.println("t2启动");
                LockSupport.park();
                System.out.println("t2 结束");
                LockSupport.unpark(t1);
            }
        });

        t1.start();
        t2.start();
    }
}
