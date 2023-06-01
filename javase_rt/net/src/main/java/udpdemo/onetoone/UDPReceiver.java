package udpdemo.onetoone;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @Author ji_ruixin
 * @Date 2023/5/30
 */
public class UDPReceiver {
	public static void main(String[] args) throws Exception{
		DatagramSocket ds = new DatagramSocket(10001);
		byte[] bytes = new byte[1024];
		DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
		while(true){
			ds.receive(dp);
			String s = new String(bytes);
			System.out.println(s);
			if (s.substring(0,3).equals("886")){
				break;
			}
		}
		ds.close();
		System.out.println("结束了");
	}
}
