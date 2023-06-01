package proxy;

import java.io.IOException;
import java.net.*;

/**
 * @Author ji_ruixin
 * @Date 2023/5/30
 */
public class ProxyDemo {
	public static void main(String[] args) throws IOException {
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 10005));
		URL url = new URL("https://www.baidu.com");

		URLConnection urlConnection = url.openConnection(proxy);

		HttpURLConnection content = (HttpURLConnection)urlConnection.getContent();
		content.setRequestMethod("GET");
		System.out.println(content.getResponseCode());
	}
}
