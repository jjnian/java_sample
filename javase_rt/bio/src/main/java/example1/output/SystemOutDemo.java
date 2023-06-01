package example1.output;

import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @Author ji_ruixin
 * @Date 2023/5/24
 */
public class SystemOutDemo {
	public static void main(String[] args) throws Exception{

		PrintStream printStream = new PrintStream(new FileOutputStream("file/system_out.txt"));
		System.setOut(printStream);
		System.out.println("system.out");


	}
}
