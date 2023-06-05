package concurrent.futuredemo;

import java.util.concurrent.*;

public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        FutureTask<String> future = new FutureTask<>(new Task());
        Thread thread = new Thread(future);
        thread.start();
        System.out.println(future.get(1,TimeUnit.SECONDS));
        System.out.println("执行结束");
    }
}

class Task implements Callable<String>{

    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        return "Task返回的值";
    }
}
