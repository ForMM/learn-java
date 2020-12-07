package learn.thread.lock.cyclicBarries;


import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 人数到了才开始干活
 */
public class CyclicBarriesDemo {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();

		CyclicBarrier cyclicBarrier = new CyclicBarrier(6, new Runnable() {
			public void run() {
				System.out.println("开始工作");
			}
		});

		Worker w1 = new Worker(cyclicBarrier, "张三");
		Worker w2 = new Worker(cyclicBarrier, "李四");
		Worker w3 = new Worker(cyclicBarrier, "王二");
		Worker w4 = new Worker(cyclicBarrier, "赵六");
		Worker w5 = new Worker(cyclicBarrier, "张杰");
		Worker w6 = new Worker(cyclicBarrier, "王强");


		executor.execute(w1);
		executor.execute(w2);
		executor.execute(w3);
		executor.execute(w4);
		executor.execute(w5);
		executor.execute(w6);

		executor.shutdown();


	}
}
