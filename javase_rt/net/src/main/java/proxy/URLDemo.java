package proxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @Author ji_ruixin
 * @Date 2023/5/30
 */
public class URLDemo {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.baidu.com");
		InputStream inputStream = url.openConnection().getInputStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		while(true){
			String s = bufferedReader.readLine();
			if (null == s){break;}
			System.out.println(s);
		}
	}
}
