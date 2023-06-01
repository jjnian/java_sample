package udpchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 *
 *
 * @Author ji_ruixin
 * @Date 2023/5/31
 *
 */
public class Chat2 {
	public static void main(String[] args) throws IOException {
		DatagramChannel dc = DatagramChannel.open();
		dc.bind(new InetSocketAddress("127.0.0.1",10002));
		dc.connect(new InetSocketAddress("127.0.0.1",10001));

		ByteBuffer byteBuffer = ByteBuffer.allocate(10);
		//byteBuffer.put("hello".getBytes());
		//byteBuffer.flip();
		//
		//dc.write(byteBuffer);
		//byteBuffer.clear();

		dc.read(byteBuffer);
		byteBuffer.clear();
		System.out.println(new String(byteBuffer.array()));

		byteBuffer.put("nihao".getBytes());
		byteBuffer.flip();

		dc.write(byteBuffer);
		dc.close();




	}
}
