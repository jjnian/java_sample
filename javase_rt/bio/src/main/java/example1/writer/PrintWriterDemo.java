package example1.writer;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * @Author ji_ruixin
 * @Date 2023/5/24
 */
public class PrintWriterDemo {
	public static void main(String[] args) throws Exception{
		PrintWriter printWriter = new PrintWriter(new FileWriter("file/PrintWriter.txt"));
		printWriter.print("我是printWriter");
		printWriter.flush();
		printWriter.close();
	}
}
