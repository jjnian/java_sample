package tcpdemo.my;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author ji_ruixin
 * @Date 2023/5/30
 */
public class Service {
	public static void main(String[] args) throws IOException, InterruptedException {
		ServerSocket serverSocket = new ServerSocket(10005);
		Socket accept = serverSocket.accept();
		InputStream in = accept.getInputStream();
		OutputStream out = accept.getOutputStream();
		//BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		//String s = bufferedReader.readLine();
		//System.out.println("---------------------");
		//while (s != null){
		//	System.out.println(s);
		//	s = bufferedReader.readLine();
		//}
		byte[] bytes = new byte[1024];
		in.read(bytes);
		System.out.println("接收客户端的消息：" + new String(bytes));

		out.write("hello client".getBytes());
		out.flush();

		out.close();
		in.close();
		accept.close();
		serverSocket.close();

	}
}
