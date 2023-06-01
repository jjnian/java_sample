import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @Author ji_ruixin
 * @Date 2023/5/31
 */
public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        AsynchronousServerSocketChannel assc = AsynchronousServerSocketChannel.open();
        assc.bind(new InetSocketAddress("127.0.0.1",10005));

        assc.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            @Override
            public void completed(AsynchronousSocketChannel result, Object attachment) {
                ByteBuffer allocate = ByteBuffer.allocate(10);
                result.read(allocate, null, new CompletionHandler<Integer, Object>() {
                    @Override
                    public void completed(Integer result, Object attachment) {
                        if (result > 0) {
                            allocate.flip();
                            byte[] data = new byte[allocate.remaining()];
                            ByteBuffer byteBuffer = allocate.get(data);
                            System.out.println(new String(byteBuffer.array()));

                        }

                    }

                    @Override
                    public void failed(Throwable exc, Object attachment) {

                    }
                });
                System.out.println(new String(allocate.array()));


                assc.accept(null,this);
            }

            @Override
            public void failed(Throwable exc, Object attachment) {

            }
        });
        Thread.currentThread().join();
    }
}
