package tcpdemo.tcpchat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ChatClient1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("127.0.0.1", 10001);

        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        out.write("hello server".getBytes());
        out.flush();

        byte[] bytes = new byte[1024];
        in.read(bytes);
        System.out.println(new String(bytes));

        Thread.sleep(3000);
        out.close();
        in.close();
        socket.close();
    }
}
