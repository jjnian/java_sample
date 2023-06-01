package udpdemo.onetomany;

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
		DatagramSocket ds = new DatagramSocket();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s = in.readLine();
			DatagramPacket dp = new DatagramPacket(s.getBytes(), s.getBytes().length, InetAddress.getByName("255.255.255.255"), 10000);
			ds.send(dp);
			if ("886".equals(s)){
				break;
			}
		}
		ds.close();
	}
}
