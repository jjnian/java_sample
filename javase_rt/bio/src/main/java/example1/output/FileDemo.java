package example1.output;

import java.io.FileOutputStream;

/**
 * @Author ji_ruixin
 * @Date 2023/5/24
 */
public class FileDemo {
	public static void main(String[] args) throws Exception{
		FileOutputStream fp = new FileOutputStream("file/FileOutputStream.txt");
		fp.write(97);
		byte[] bytes = new byte[]{97,98,99,100,101};
		// 数组 数组的漂移量 读取数组几个值
		fp.write(bytes);
		fp.flush();
		fp.close();
	}
}
