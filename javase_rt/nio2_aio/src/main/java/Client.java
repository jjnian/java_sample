import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        AsynchronousSocketChannel open = AsynchronousSocketChannel.open();
        Future<Void> connect = open.connect(new InetSocketAddress("127.0.0.1", 10005));
        connect.get();

        ByteBuffer allocate = ByteBuffer.allocate(10);
        allocate.put("hello".getBytes());
        allocate.flip();
        open.write(allocate, null, new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer result, Object attachment) {
                open.write(allocate, null, this);
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
            }
        });

        open.close();


    }
}
