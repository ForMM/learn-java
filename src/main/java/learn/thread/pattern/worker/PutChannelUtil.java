package learn.thread.pattern.worker;

public class PutChannelUtil {

    public static  Channel channel;
    static {
        channel = new Channel(5); // 工人线程的數量
        channel.startWorkers();
    }

    public static void main(String[] args) {



        int requestNumber=1;
        for(int i=0;i<5;i++)
        {
            Request request=new Request("client1",requestNumber);
            try {
                Thread.sleep(5000);
                requestNumber++;
                channel.putRequest(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }



}
