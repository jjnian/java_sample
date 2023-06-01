package tcpchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open(new InetSocketAddress("127.0.0.1", 10005));
        sc.configureBlocking(false);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        while(true){
            String s = in.readLine();
            byteBuffer.put(s.getBytes());
            byteBuffer.flip();
            sc.write(byteBuffer);
            byteBuffer.clear();
            sc.read(byteBuffer);
            System.out.println("接收的消息是：" + new String(byteBuffer.array()));
            if ("886".equals(s)){break;}
        }
        in.close();
        sc.close();
    }
}
