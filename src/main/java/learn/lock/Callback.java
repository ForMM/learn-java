package learn.lock;

/**
 * 回调函数
 */
public interface Callback {

    /**
     * 获取锁后回调方法
     * @return
     */
    public Object genLock();

    /**
     * 获取锁超时后的回调方法
     * @return
     */
    public Object timeOut();

}
