package tcpdemo.my;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author ji_ruixin
 * @Date 2023/5/30
 */
public class Client {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("127.0.0.1",10005);
		OutputStream out = socket.getOutputStream();
		InputStream in = socket.getInputStream();

		// 写数据
		out.write("hello server".getBytes());
		out.flush();

		// 读数据
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
		String s = bufferedReader.readLine();
		while (s!=null){
			System.out.println("服务器返回的消息：" + s);
			s = bufferedReader.readLine();
		}
		out.close();
		in.close();
		socket.close();
	}
}
