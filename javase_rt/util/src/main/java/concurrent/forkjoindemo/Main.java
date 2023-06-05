package concurrent.forkjoindemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTaskDemo forkJoinTaskDemo = new ForkJoinTaskDemo(1L, 10_0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(forkJoinTaskDemo);
        System.out.println(submit.get());
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        // test1();
    }

    public static void test1(){
        long start = System.currentTimeMillis();
        long sum = 0L;
        for (long i = 0; i < 10_0000_0000L; i++) {
            sum += i;
        }
        System.out.println(sum);
        long end = System.currentTimeMillis();

        System.out.println(end-start);
    }
}
