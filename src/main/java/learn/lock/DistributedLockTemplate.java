package learn.lock;

import learn.lock.Callback;

/**
 * 分布式锁模版类
 */
public interface DistributedLockTemplate {

    /**
     *
     * @param lockId 锁id(对应业务唯一ID)
     * @param timeOut 单位毫秒
     * @param callback 回调函数
     * @return
     */
    public Object execute(String lockId, int timeOut, Callback callback);
}
