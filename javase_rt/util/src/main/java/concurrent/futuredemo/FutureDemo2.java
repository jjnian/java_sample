package concurrent.futuredemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureDemo2 {
    public static void main(String[] args) throws Exception{
        ExecutorService es = Executors.newCachedThreadPool();
        Future<String> submit = es.submit(new Task());
        System.out.println(submit.get(1, TimeUnit.SECONDS));
        System.out.println("执行结束");
    }
}
