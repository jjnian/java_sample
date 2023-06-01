package example1.input;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @Author ji_ruixin
 * @Date 2023/5/24
 */
public class SystemInDemo {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("file/system_out.txt"));
		InputStream in = System.in;
		int read = in.read();
		while(read > -1){
			System.out.print((char)read);
			read = in.read();
		}
	}
}
