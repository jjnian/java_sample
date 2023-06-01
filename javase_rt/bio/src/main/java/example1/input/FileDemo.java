package example1.input;

import java.io.File;
import java.io.FileInputStream;

/**
 * @Author ji_ruixin
 * @Date 2023/5/24
 */
public class FileDemo {
	public static void main(String[] args) throws Exception {
		File file = new File("file/text.txt");
		FileInputStream fs = new FileInputStream(file);
		byte[] bytes = new byte[20];
		System.out.println(fs.available());
		fs.read(bytes);
		for(byte b : bytes) {
			if (b == 0) {
				System.out.println("没数据");
			}else if(b < 30){
				System.out.println(b);
			}else if(b == 32){
				System.out.println("空格");
			}
			else {
				System.out.println((char) b);
			}
		}
	}

}
