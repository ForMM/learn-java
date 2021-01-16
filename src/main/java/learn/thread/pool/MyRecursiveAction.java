package learn.thread.pool;

import java.util.concurrent.RecursiveAction;

public class MyRecursiveAction extends RecursiveAction {

    private int begin;
    private int end;

    public MyRecursiveAction(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected void compute() {
        System.out.println(Thread.currentThread().getName()+"--------");

        if (end-begin>2){
            int middle = (begin+end)/2;
            MyRecursiveAction leftM = new MyRecursiveAction(begin,middle);
            MyRecursiveAction right = new MyRecursiveAction(middle+1,end);
            this.invokeAll(leftM,right);
        }else {
            System.out.println("打印组合："+begin+"-"+end);
        }



    }
}
