package learn.lock.zk;

import learn.lock.DistributedReentrantLock;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 基于Zookeeper的可重入互斥锁
 */
public class ZkReentrantLock implements DistributedReentrantLock {

    /**
     * 所有PERSISTENT锁节点的根位置
     */
    public static final String rootPath = "/ROOT_LOCK/";

    /**
     * 锁id，对应zk一个PERSISTENT节点,下挂EPHEMERAL节点.
     */
    private String lockPath;

    /**
     * zk客户端
     */
    private CuratorFramework client;

    /**
     * 共享锁的实现
     */
    private InterProcessMutex mutex = null;

    /**
     * 每次延迟清理PERSISTENT节点的时间  Unit:MILLISECONDS
     */
    private long delayTimeForClean = 1000;

    private static final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);


    /**
     * 构造zk连接对象
     * @param lockId
     * @param client
     */
    public ZkReentrantLock(String lockId, CuratorFramework client) {
       init(lockId,client);
    }

    public void init(String lockId, CuratorFramework client) {
        this.lockPath = rootPath+lockId;
        this.client = client;
        this.mutex = new InterProcessMutex(client,this.lockPath);
    }

    @Override
    public boolean tryLock(long timeOut, TimeUnit timeUnit) {
        try {
            return mutex.acquire(timeOut,timeUnit);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage(),e);
        }
    }

    @Override
    public void unLock() {
        try {
            mutex.release();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage(),e);
        }finally {
            executorService.schedule(new Cleaner(client,lockPath),delayTimeForClean,TimeUnit.MILLISECONDS);
        }
    }

    /**
     *
     */
    static class Cleaner implements Runnable{

        CuratorFramework client;
        String path;

        public Cleaner(CuratorFramework client, String path) {
            this.client = client;
            this.path = path;
        }

        @Override
        public void run() {
            try {
                List<String> strings = client.getChildren().forPath(path);
                if (strings==null || strings.isEmpty()){
                    client.delete().forPath(path);
                }
            }catch (Exception e){
                //准备删除时,正好有线程创建锁
            }

        }
    }

}
