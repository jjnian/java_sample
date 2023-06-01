package udpdemo.onetogroup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Author ji_ruixin
 * @Date 2023/5/30
 */
public class Sender {
	public static void main(String[] args) throws Exception{
		DatagramSocket datagramSocket = new DatagramSocket();
		DatagramPacket datagramPacket = new DatagramPacket("hello".getBytes(), "hello".getBytes().length, InetAddress.getByName("224.0.0.1"), 10000);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		while(true){
			String s = in.readLine();
			datagramPacket.setData(s.getBytes("UTF-8"),0,s.length());
			datagramSocket.send(datagramPacket);
			if ("886".equals(s)){break;}
		}
		datagramSocket.close();

	}
}
