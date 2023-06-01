package udpdemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Author ji_ruixin
 * @Date 2023/5/30
 */
public class ReceiverAndSender {
	public static void main(String[] args) throws Exception{
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(in);

		DatagramSocket receiver = new DatagramSocket(10001);

		while(true){
			String s = bufferedReader.readLine();
			// 发送消息
			DatagramPacket datagramPacket = new DatagramPacket(s.getBytes(),s.getBytes().length, InetAddress.getLocalHost(), 10001);
			receiver.send(datagramPacket);

			// 接收消息
			byte[] bytes = new byte[1024];
			DatagramPacket datagramPacket1 = new DatagramPacket(bytes, bytes.length);
			receiver.receive(datagramPacket1);
			System.out.println("接受的消息是：" + new String(bytes));
			if (s.equals("886")){break;}
		}
		receiver.close();
	}
}
