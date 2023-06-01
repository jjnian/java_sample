package port;

import java.net.*;
import java.util.Enumeration;

/**
 * @Author ji_ruixin
 * @Date 2023/6/1
 */
public class PortDemo {
	public static void main(String[] args) {
		try {
			Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
			while (networkInterfaces.hasMoreElements()) {
				NetworkInterface networkInterface = networkInterfaces.nextElement();
				Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
				while (inetAddresses.hasMoreElements()) {
					InetAddress inetAddress = inetAddresses.nextElement();
					if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
						System.out.println("Network Interface: " + networkInterface.getName());
						System.out.println("IP Address: " + inetAddress.getHostAddress());
						System.out.println("Open Ports:");

						for (int port = 1; port <= 65535; port++) {
							try {
								Socket socket = new Socket();
								socket.connect(new InetSocketAddress(inetAddress, port), 10);
								socket.close();
								System.out.println(port);
							} catch (Exception e) {
								// 端口不可用
							}
						}

						System.out.println("------------------------------");
					}
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
}

