package example1.input;

import java.io.FileInputStream;
import java.io.PushbackInputStream;

/**
 * @Author ji_ruixin
 * @Date 2023/5/24
 */
public class PushBackDemo {
	public static void main(String[] args) throws Exception{
		// 可以把读取的数据再推回去
		PushbackInputStream pi = new PushbackInputStream(new FileInputStream("file/text.txt"));
		int read = pi.read();
		System.out.println("第一次读取："+(char)read);
		pi.unread(read);
		read = pi.read();
		System.out.println("第二次读取："+(char)read);
	}
}
