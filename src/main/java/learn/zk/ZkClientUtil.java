package learn.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

public class ZkClientUtil {
    /**
     *  定义失败重试间隔时间 单位:毫秒
     */
    private static final int try_time = 5000;
    /**
     * 定义失败重试次数
     */
    private static final int max_retries = 3;
    /**
     * 定义会话存活时间,根据业务灵活指定 单位:毫秒
     */
    private static final int session_time_out = 10000000;
    /**
     * zk url端口
     */
    private static final String zk_url = "127.0.0.1:2181";
    /**
     * 命名空间
     */
    private static final String namespace = "zk_name";


    /**
     * 通过curator建立与zk的连接
     * @return
     */
    public static CuratorFramework build(){
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(try_time,max_retries);
        CuratorFramework client = CuratorFrameworkFactory.builder().connectString(zk_url).retryPolicy(retryPolicy).namespace(namespace).sessionTimeoutMs(session_time_out).build();
        return client;
    }

    public static void create() throws Exception {
        CuratorFramework curatorFramework = ZkClientUtil.build();
        curatorFramework.create().creatingParentContainersIfNeeded() //如果必须创建父节点
                .withMode(CreateMode.PERSISTENT) //节点类型
                .withACL(null) //权限
                .forPath("/createNode/node"); //节点
    }

    public static void main(String[] args) throws Exception{
        create();
        CuratorFramework framework = ZkClientUtil.build();

        framework.setData() //修改节点
                .forPath("/createNode/node", "node1".getBytes());
        //获取节点数据
        framework.getData()
                .forPath("/createNode");
        //获取子节点
        framework.getChildren()
                .forPath("/createNode");
        //删除节点
        framework.delete()
                .deletingChildrenIfNeeded(); //如果必须删除子节点


    }

}
