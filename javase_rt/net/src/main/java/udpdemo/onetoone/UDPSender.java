package udpdemo.onetoone;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Author ji_ruixin
 * @Date 2023/5/30
 */
public class UDPSender {
	public static void main(String[] args) throws Exception{
		InputStream in = System.in;
		InputStreamReader inputStreamReader = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(inputStreamReader);
		DatagramSocket ds = new DatagramSocket();
		DatagramPacket dp = new DatagramPacket("start".getBytes(),"start".getBytes().length, InetAddress.getLocalHost(), 10001);
		while(true){
			String s = br.readLine();
			dp.setData(s.getBytes(),0,s.length());
			ds.send(dp);
			if (s.equals("886")){break;}
		}
		ds.close();
		System.out.println("结束了");
	}
}
