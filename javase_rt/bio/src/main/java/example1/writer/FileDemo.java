package example1.writer;

import java.io.FileWriter;

/**
 * @Author ji_ruixin
 * @Date 2023/5/24
 */
public class FileDemo {
	public static void main(String[] args) throws Exception{
		FileWriter fileWriter = new FileWriter("file/FileWriter.txt");
		fileWriter.write(97);
		fileWriter.write("我叫纪锐鑫");
		fileWriter.flush();
		fileWriter.close();
	}
}
