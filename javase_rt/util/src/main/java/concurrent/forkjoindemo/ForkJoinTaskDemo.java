package concurrent.forkjoindemo;

import java.util.concurrent.RecursiveTask;

public class ForkJoinTaskDemo extends RecursiveTask<Long> {

    private Long start;

    private Long end;

    private Long temp = 10000L;

    public ForkJoinTaskDemo(Long start, Long end){
        this.start = start;
        this.end = end;
    }

    public Long getTemp() {
        return temp;
    }

    public void setTemp(Long temp) {
        this.temp = temp;
    }

    @Override
    protected Long compute() {
        if ((end - start) < temp){
            Long sum = 0L;
            for (long i = 0; i < end; i++) {
                sum += i;
            }
            return sum;
        }else{
            long middle = (start + end) / 2;
            ForkJoinTaskDemo taks1 = new ForkJoinTaskDemo(start, middle);
            taks1.fork();
            ForkJoinTaskDemo task2 = new ForkJoinTaskDemo(middle + 1, end);
            task2.fork();
            return taks1.join() + task2.join();
        }
    }
}
