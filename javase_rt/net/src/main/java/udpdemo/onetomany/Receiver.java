package udpdemo.onetomany;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;

/**
 * @Author ji_ruixin
 * @Date 2023/5/30
 */
public class Receiver {
	public static void main(String[] args){
		System.out.println("start");
		MulticastSocket ms = null;
		try {
			ms = new MulticastSocket(10000);
			byte[] bytes = new byte[1024];
			DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
			while(true){
				ms.receive(dp);
				String s = new String(bytes);
				System.out.println("receive message:" + s);
				if (s.substring(0,3).equals("886")){break;}
			}
			ms.close();
			System.out.println("end");
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
}
