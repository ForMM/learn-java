package learn.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class FutureT {


   private static class CallHello implements Callable{
       private String name;

       public CallHello(String name) {
           this.name = name;
       }

       public Object call() throws Exception {
           Thread.sleep(3000);
           return this.name+", say hello world1";
       }
   }


    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask(new CallHello("张三"));
        FutureTask futureTask1 = new FutureTask(new CallHello("李四"));
        FutureTask futureTask2 = new FutureTask(new CallHello("王五"));
        new Thread(futureTask).start();
        new Thread(futureTask1).start();
        new Thread(futureTask2).start();

        try {
            String aa = (String)futureTask.get();
            String bb = (String)futureTask1.get();
            String cc = (String)futureTask2.get();
            System.out.println(aa+bb+cc);
        }catch (Exception e){

        }


    }


}
