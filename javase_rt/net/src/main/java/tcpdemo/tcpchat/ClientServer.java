package tcpdemo.tcpchat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10001);

        while(true){
            Socket socket = serverSocket.accept();
            new Thread(()->{
                OutputStream out = null;
                InputStream in = null;
                try {
                    out = socket.getOutputStream();
                    in = socket.getInputStream();

                    byte[] bytes = new byte[1024];
                    in.read(bytes);
                    System.out.println(new String(bytes));
                    out.write("收到信息".getBytes());
                    out.flush();
                    Thread.sleep(1000);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        in.close();
                        out.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        //serverSocket.close();

    }
}
