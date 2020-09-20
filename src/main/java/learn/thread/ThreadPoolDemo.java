package learn.thread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolDemo {
	public static class MyTask implements Runnable{
		public void run() {
			System.out.println(System.currentTimeMillis() + "Thread id:" +Thread.currentThread().getId());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized static void main(String[] args) {
		MyTask task = new MyTask();
		ExecutorService newFixedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			newFixedThreadPool.submit(task);
		}
		
		Map<Object, Object> synchronizedMap = Collections.synchronizedMap(new HashMap<Object, Object>());
		
		ConcurrentLinkedQueue<Map<String, Object>> concurrentLinkedQueue = new ConcurrentLinkedQueue<Map<String,Object>>();
		ConcurrentLinkedQueue<String> concurrentLinkedQueue2 = new ConcurrentLinkedQueue<String>();
		concurrentLinkedQueue2.add("11111");
		concurrentLinkedQueue2.add("22222");
		
		ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<String, String>();
		
		ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();
		threadLocal.set("1");
		Object object = threadLocal.get();
		System.out.println(object.toString());
		
		
		SynchronousQueue<String> synchronousQueue = new SynchronousQueue<String>();
		synchronousQueue.add("sss");
		try {
			String take = synchronousQueue.take();
			synchronousQueue.put("hhhhh");
			synchronousQueue.offer("");
			synchronousQueue.poll();
			synchronousQueue.peek();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		AtomicInteger result = new AtomicInteger(-1);
		
		
		
	}

}
