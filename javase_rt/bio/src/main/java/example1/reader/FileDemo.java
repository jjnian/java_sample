package example1.reader;

import java.io.FileReader;

/**
 * @Author ji_ruixin
 * @Date 2023/5/24
 */
public class FileDemo {
	public static void main(String[] args) throws Exception{
		FileReader fileReader = new FileReader("file/FileWriter.txt");
		//int read = fileReader.read();
		//while(read > -1){
		//	System.out.print((char)read);
		//	read = fileReader.read();
		//}
		System.out.println("------------------------");
		char[] chars = new char[10];
		fileReader.read(chars,2,2);
		for(char c : chars){
			if (c == 0){
				System.out.println("没数据");
			}else{
				System.out.print(c);
			}

		}

	}
}
