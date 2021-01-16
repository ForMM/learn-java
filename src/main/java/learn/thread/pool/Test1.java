package learn.thread.pool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class Test1 {
    public static void main(String[] args) throws Exception{
        MyRecursiveTask myRecursiveTask = new MyRecursiveTask();
        ForkJoinPool joinPool = new ForkJoinPool();
        ForkJoinTask<Integer> submit = joinPool.submit(myRecursiveTask);
        submit.fork();
        Integer integer = submit.get();
        System.out.println("integer:"+integer);

    }
}
