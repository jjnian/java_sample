package example1.output;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * @Author ji_ruixin
 * @Date 2023/5/24
 */
public class BufferedDemo {
	public static void main(String[] args) throws Exception{
		// 在调用write(int b)这个方法时会先存入内置数组
		// 等攒到一定数量再直接写入到文件中
		BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream("file/BufferedOutputStream.txt"));
		bo.write(97);
		bo.flush();
		bo.close();
	}
}
