package learn.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SingletonThreadPool {

	private static int corePoolSize = 10;
	private static int maxPoolSize = 100;
	private static int keepAliveTime = 100;
	private static int blockingQueueSize = 1000;

	private ExecutorService executorService;

	private SingletonThreadPool() {
		executorService = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, TimeUnit.MICROSECONDS,
				new LinkedBlockingQueue<Runnable>(blockingQueueSize));
	}

	private static class SingletonContainer {
		private static SingletonThreadPool instance = new SingletonThreadPool();
	}

	public static SingletonThreadPool getInstance() {
		return SingletonContainer.instance;
	}

	public ExecutorService getThreadPool() {
		return executorService;
	}

}
