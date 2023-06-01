package udpdemo.onetogroup;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * @Author ji_ruixin
 * @Date 2023/5/30
 */
public class Receiver {
	public static void main(String[] args) throws Exception{
		MulticastSocket ms = new MulticastSocket(10000);
		InetAddress addr = InetAddress.getByName("224.0.0.1");
		ms.joinGroup(addr);
		byte[] bytes = new byte[1024];
		DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
		while (true){
			ms.receive(dp);
			String s = new String(bytes,"UTF-8");
			String hostAddress = dp.getAddress().getHostAddress();
			int port = dp.getPort();
			System.out.println("来自" + hostAddress + "-" + port + "：" + s);
			if (s.substring(0,3).equals("886")){break;}
		}
		ms.close();
	}


}
