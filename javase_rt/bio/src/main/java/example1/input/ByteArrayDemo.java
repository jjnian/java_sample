package example1.input;

import java.io.ByteArrayInputStream;

/**
 * @Author ji_ruixin
 * @Date 2023/5/24
 */
public class ByteArrayDemo {
	public static void main(String[] args) {
		// 传入带数据的数组
		ByteArrayInputStream bi = new ByteArrayInputStream(new byte[1024]);
		int read1 = bi.read();
		System.out.println(read1);
	}
}
