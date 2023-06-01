import java.util.Map;
import java.util.Properties;

/**
 * @Author ji_ruixin
 * @Date 2023/6/1
 */
public class SystemDemo {
	public static void main(String[] args) {
		// 获取JVM的参数
		Properties properties = System.getProperties();

		// 获取操作系统的环境变量
		Map<String, String> getenv = System.getenv();

		// 目前没搞明白
		SecurityManager sm = System.getSecurityManager();
	}
}
