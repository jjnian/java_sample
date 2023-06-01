package example1.reader;

import java.io.FileReader;
import java.io.LineNumberReader;

/**
 * @Author ji_ruixin
 * @Date 2023/5/24
 */
public class LineNumberDemo {
	public static void main(String[] args) throws Exception{
		// 只是做一个读到第几行的标记
		// 并不会从头再读
		LineNumberReader lnr = new LineNumberReader(new FileReader("file/FileWriter.txt"));
		System.out.println(lnr.readLine());
		lnr.setLineNumber(0);
		System.out.println(lnr.getLineNumber());
		System.out.println(lnr.readLine());
	}
}
