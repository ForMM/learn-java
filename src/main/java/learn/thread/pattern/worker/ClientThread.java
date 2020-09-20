package learn.thread.pattern.worker;

import java.util.Random;

public class ClientThread extends Thread{

    private final Channel channel;
    private static final Random random = new Random();

    public ClientThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        while(true) {
            Request request = new Request(getName(), random.nextInt(1000));
            try {
                channel.putRequest(request);
                Thread.sleep(random.nextInt(1000));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
