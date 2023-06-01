package example1.output;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @Author ji_ruixin
 * @Date 2023/5/24
 */
public class DataDemo {
	public static void main(String[] args) throws Exception{
		// 往文件里写数据，学到数据中的是乱码，
		// 需要配合DataInputStream读取里面的信息
		DataOutputStream dp = new DataOutputStream(new FileOutputStream("file/text1.txt"));
		dp.writeBoolean(false);
		dp.writeChar('a');
		dp.flush();
		dp.close();

		DataInputStream di = new DataInputStream(new FileInputStream("text1.txt"));
		System.out.println(di.readBoolean());
		System.out.println(di.readChar());
	}
}
