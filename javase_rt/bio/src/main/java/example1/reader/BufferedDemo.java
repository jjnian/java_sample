package example1.reader;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @Author ji_ruixin
 * @Date 2023/5/24
 */
public class BufferedDemo {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("file/FileWriter.txt"));
		System.out.println(br.readLine());

	}
}
