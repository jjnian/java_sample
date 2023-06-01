package example1.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * @Author ji_ruixin
 * @Date 2023/5/24
 */
public class BufferedDemo {
	public static void main(String[] args) throws Exception{
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("file/BufferedWriter.txt"));
		bufferedWriter.write("我是bufferedWriter");
		bufferedWriter.flush();
		bufferedWriter.close();
	}
}
