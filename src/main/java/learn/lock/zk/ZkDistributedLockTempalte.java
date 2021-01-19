package learn.lock.zk;

import learn.lock.Callback;
import learn.lock.DistributedLockTemplate;
import org.apache.curator.framework.CuratorFramework;

import java.util.concurrent.TimeUnit;

public class ZkDistributedLockTempalte implements DistributedLockTemplate {

    private CuratorFramework client;

    public ZkDistributedLockTempalte(CuratorFramework client) {
        this.client = client;
    }

    /**
     *
     * @param zkReentrantLock
     * @param timeOut
     * @return
     */
    private boolean tryLock(ZkReentrantLock zkReentrantLock,long timeOut){
        return zkReentrantLock.tryLock(timeOut, TimeUnit.MILLISECONDS);
    }

    @Override
    public Object execute(String lockId, int timeOut, Callback callback) {
        ZkReentrantLock zkReentrantLock = null;
        boolean getLock = false;

        try {
            zkReentrantLock = new ZkReentrantLock(lockId,client);
            if(tryLock(zkReentrantLock,new Long(timeOut))){
                getLock = true;
                return callback.genLock();
            }else {
                return callback.timeOut();
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("error");
        }finally {
            if (getLock){
                zkReentrantLock.unLock();
            }
        }
        return null;
    }
}
