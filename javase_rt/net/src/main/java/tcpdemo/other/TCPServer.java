package tcpdemo.other;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author ji_ruixin
 * @Date 2023/5/30
 */
public class TCPServer {
	public static void main(String[] args) {
		try {
			// 创建ServerSocket对象，指定监听的端口号
			ServerSocket serverSocket = new ServerSocket(8888);

			System.out.println("服务器启动，等待客户端连接...");

			// 等待客户端连接
			Socket clientSocket = serverSocket.accept();

			System.out.println("客户端已连接：" + clientSocket.getInetAddress().getHostAddress());

			// 获取输入流和输出流
			InputStream inputStream = clientSocket.getInputStream();
			OutputStream outputStream = clientSocket.getOutputStream();

			// 接收客户端发送的数据
			byte[] buffer = new byte[1024];
			int length = inputStream.read(buffer);
			String clientMessage = new String(buffer, 0, length);
			System.out.println("收到客户端消息：" + clientMessage);

			// 发送响应给客户端
			String serverMessage = "Hello, Client!";
			outputStream.write(serverMessage.getBytes());
			outputStream.flush();

			// 关闭流和连接
			inputStream.close();
			outputStream.close();
			clientSocket.close();
			serverSocket.close();

			System.out.println("服务器关闭");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
