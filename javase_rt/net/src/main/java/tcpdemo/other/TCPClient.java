package tcpdemo.other;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author ji_ruixin
 * @Date 2023/5/30
 */
public class TCPClient {
	public static void main(String[] args) {
		try {
			// 创建Socket对象，指定服务器的IP地址和端口号
			Socket socket = new Socket("localhost", 8888);

			// 获取输入流和输出流
			InputStream inputStream = socket.getInputStream();
			OutputStream outputStream = socket.getOutputStream();

			// 发送数据给服务器
			String clientMessage = "Hello, Server!";
			outputStream.write(clientMessage.getBytes());
			outputStream.flush();

			// 接收服务器的响应
			byte[] buffer = new byte[1024];
			int length = inputStream.read(buffer);
			String serverMessage = new String(buffer, 0, length);
			System.out.println("收到服务器消息：" + serverMessage);

			// 关闭流和连接
			inputStream.close();
			outputStream.close();
			socket.close();

			System.out.println("客户端关闭");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
