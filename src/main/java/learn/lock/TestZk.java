package learn.lock;

import learn.lock.zk.ZkDistributedLockTempalte;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class TestZk {
    public static void main(String[] args) {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1:2181", retryPolicy);
        client.start();

        final ZkDistributedLockTempalte template=new ZkDistributedLockTempalte(client);
        template.execute("订单流水号", 5000, new Callback() {
            @Override
            public Object genLock() {

                System.out.println("genLock");

                return null;
            }

            @Override
            public Object timeOut() {

                System.out.println("timeOut");
                return null;
            }
        });

    }


}
