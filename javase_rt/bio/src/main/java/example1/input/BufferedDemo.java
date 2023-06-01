package example1.input;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * @Author ji_ruixin
 * @Date 2023/5/24
 */
public class BufferedDemo {
	public static void main(String[] args) throws Exception {
		// 内部维护了一个byte数组
		BufferedInputStream bs = new BufferedInputStream(new FileInputStream("file/text.txt"),10);
		int read = bs.read();
		while(read > -1){
			System.out.println((char)read);
			read = bs.read();
		}
	}
}
