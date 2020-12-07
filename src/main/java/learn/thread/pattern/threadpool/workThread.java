package learn.thread.pattern.threadpool;

public class workThread implements Runnable {

	private String work;

	public workThread(String work) {
		this.work = work;
	}

	public void run() {
		System.out.println("thread name:" + Thread.currentThread().getName() + " do " + work);
	}
}
