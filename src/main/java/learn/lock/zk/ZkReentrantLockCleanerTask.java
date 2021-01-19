package learn.lock.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ZkReentrantLockCleanerTask extends TimerTask {

    private CuratorFramework client;
    private Timer timer;

    /**
     * 检查周期
     */
    private long period = 5000;

    private int maxRetries = 3;
    private final int baseSleepTimems = 1000;

    public ZkReentrantLockCleanerTask(String  zkAddress) {
        try{
            RetryPolicy retryPolicy = new ExponentialBackoffRetry(baseSleepTimems, maxRetries);
            client = CuratorFrameworkFactory.newClient(zkAddress, retryPolicy);
            client.start();
        }catch (Exception e){
        }catch (Throwable ex){
            ex.printStackTrace();
        }
    }

    public void start(){
        timer.schedule(this,0,period);
    }

    private boolean isEmpty(List<String> list){
        return list == null || list.isEmpty();
    }

    @Override
    public void run() {
        try {
            List<String> childrenPaths=this.client.getChildren().forPath(ZkReentrantLock.rootPath);
            for(String path:childrenPaths){
                cleanNode(path);
            }
        }catch (Exception e){

        }
    }

    private void cleanNode(String path){
        try {
            if(isEmpty(this.client.getChildren().forPath(path))){
                this.client.delete().forPath(path);//利用存在子节点无法删除和zk的原子性这两个特性.
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
