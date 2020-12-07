package learn.thread.pattern.worker;

public class TestMain {
	public static void main(String[] args) {
		Channel channel = new Channel(5); // 工人线程的數量
		channel.startWorkers();
		new ClientThread("aaa", channel).start();
		new ClientThread("bbb", channel).start();
		new ClientThread("ccc", channel).start();
	}

}
