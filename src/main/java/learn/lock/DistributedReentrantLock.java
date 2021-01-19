package learn.lock;

import java.util.concurrent.TimeUnit;

/**
 * 分布式锁（可重入）接口
 */
public interface DistributedReentrantLock {

    /**
     *  获取锁
     * @param timeOut 超时时间
     * @param timeUnit 时间单位
     * @return
     */
    public boolean tryLock(long timeOut, TimeUnit timeUnit);

    /**
     * 释放锁
     */
    public void unLock();
}
