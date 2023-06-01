package example1.output;

import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @Author ji_ruixin
 * @Date 2023/5/24
 */
public class PrintStreamDemo {
	public static void main(String[] args) throws Exception{
		PrintStream printStream = new PrintStream(new FileOutputStream("file/PrintStream.txt"));
		printStream.println("我叫纪锐鑫");
		printStream.write(97);
		printStream.flush();
		printStream.close();
	}
}
