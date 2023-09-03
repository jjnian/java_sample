public class VolatileDemo {
    private volatile int flag = 0;

    public static void main(String[] args) throws InterruptedException {
        VolatileDemo example = new VolatileDemo();

        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                example.flag = 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread readerThread = new Thread(() -> {
            while (example.flag == 0) {
                // System.out.println(example.flag);
                // 循环等待，直到 flag 变为 true
            }
            System.out.println("Flag is true, exiting...");
        });

        writerThread.start();
        readerThread.start();


    }

    // private boolean flag = false;
    //
    // public static void main(String[] args) {
    //     Test1 example = new Test1();
    //
    //     Thread writerThread = new Thread(() -> {
    //         try {
    //             Thread.sleep(1000); // 模拟其他耗时操作
    //             example.flag = true; // 修改 flag 的值
    //             System.out.println("Flag set to true");
    //         } catch (InterruptedException e) {
    //             e.printStackTrace();
    //         }
    //     });
    //
    //     Thread readerThread = new Thread(() -> {
    //         while (!example.flag) {
    //             // 循环等待，直到 flag 变为 true
    //         }
    //         System.out.println("Flag is true, exiting...");
    //     });
    //
    //     writerThread.start();
    //     readerThread.start();
    // }

}
