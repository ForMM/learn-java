package learn.jvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.InflaterInputStream;

public class MonitoringTest {
	static class OOMObject {
		public byte[] placeHolder = new byte[64 * 1024];
	}

	public static void fillHeap(int num) throws InterruptedException {
		List<OOMObject> aa = new ArrayList<OOMObject>();
		for (int i = 0; i < num; i++) {
			Thread.sleep(500);
			aa.add(new OOMObject());
		}
		System.gc();
	}

	/**
	 * 死循环演示
	 */
	public static void createBusyThread() {
		Thread thread = new Thread(new Runnable() {

			public void run() {
				while (true) {
					;
				}

			}
		}, "testbusythread");
		thread.run();

	}

	/**
	 * 锁等待
	 * @param lock
	 */
	public static void createLockThread(final Object lock) {
		Thread thread = new Thread(new Runnable() {

			public void run() {
				synchronized (lock) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						System.out.println(e);
					}
				}

			}
		}, "testlockthread");
		thread.start();
	}

	static class SynAddRunable implements Runnable {
		int a, b;

		public SynAddRunable(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public void run() {
			synchronized (Integer.valueOf(a)) {
				synchronized (Integer.valueOf(b)) {
					System.out.println(a + b);
				}
			}

		}

	}

	public static void main(String[] args) throws InterruptedException, IOException {
		//		fillHeap(1000);

		//		BufferedReader bd = new BufferedReader(new InputStreamReader(System.in));
		//		bd.readLine();
		//		createBusyThread();
		//		bd.readLine();
		//		Object o = new Object();
		//		createLockThread(o);

		for (int i = 0; i < 100; i++) {
			new Thread(new SynAddRunable(1, 2)).start();
			new Thread(new SynAddRunable(2, 1)).start();
		}


	}

}
