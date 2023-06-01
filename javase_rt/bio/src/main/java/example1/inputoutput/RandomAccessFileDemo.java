package example1.inputoutput;

import java.io.RandomAccessFile;

/**
 * @Author ji_ruixin
 * @Date 2023/5/25
 */
public class RandomAccessFileDemo {
	public static void main(String[] args) throws Exception {
		RandomAccessFile raf = new RandomAccessFile("file/RandomAccessFile.txt","rw");
		System.out.println(raf.getFilePointer());

		raf.write(97);
		System.out.println(raf.getFilePointer());

		System.out.println((char)raf.read());


	}
}
