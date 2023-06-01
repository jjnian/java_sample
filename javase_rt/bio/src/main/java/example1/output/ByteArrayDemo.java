package example1.output;

import java.io.ByteArrayOutputStream;

/**
 * @Author ji_ruixin
 * @Date 2023/5/24
 */
public class ByteArrayDemo {
	public static void main(String[] args) throws Exception {
		// 把数据写入到内置的数组中
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		bo.write(97);
		bo.write(98);
		bo.write(99);
		byte[] bytes = bo.toByteArray();
		bo.flush();
		bo.close();
		for(byte b : bytes){
			System.out.println((char)b);
		}
	}
}
