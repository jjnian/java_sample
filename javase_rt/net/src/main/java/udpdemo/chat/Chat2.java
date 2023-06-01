package udpdemo.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Author ji_ruixin
 * @Date 2023/5/30
 */
public class Chat2 {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket ds = new DatagramSocket(10001);
		byte[] receiverByte = new byte[1024];
		DatagramPacket reveiver = new DatagramPacket(receiverByte,receiverByte.length);
		byte[] bytes = new byte[1024];
		DatagramPacket sender = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.22.169"), 10002);

		new Thread(()->{
			while(true){
				try {
					ds.receive(reveiver);
				} catch (IOException e) {
					e.printStackTrace();
				}
				String hostAddress = reveiver.getAddress().getHostAddress();
				int port = reveiver.getPort();
				System.out.println("\nfrom:" + hostAddress + "-" + port + "message:" + new String(receiverByte).trim());
			}
		}).start();

		while(true){
			String s = in.readLine();
			sender.setData(s.getBytes(),0,s.length());
			ds.send(sender);
			if (s.equals("886")){ds.close();break;}
		}
		System.exit(0);
	}
}
