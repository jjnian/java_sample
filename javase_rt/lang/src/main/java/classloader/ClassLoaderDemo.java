package classloader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 *
 */
public class ClassLoaderDemo {
	public static void main(String[] args) {
		test1();
	}

	/**
	 * 测试类加载只能加载对应的classpath下的文件，其他文件都是null
	 * @Date 2023/8/21 9:16
	 */
	public static void test(){
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		URL resource = contextClassLoader.getResource("mybatis-config.xml");
		try {
			InputStream inputStream = resource.openStream();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 测试
	 * 扩展类加载器（Extension Class Loader）
	 *
	 * 启动类获取不到，是JVM层面的。
	 * 启动类加载器（Bootstrap Class Loader）
	 * @Date 2023/8/21 9:16
	 */
	public static void test1(){
		// 获取应用程序类加载器（Application Class Loader）
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		// 获取扩展类加载器
		ClassLoader extension = contextClassLoader.getParent();
		// URL resource = extension.getResource("com/sun/nio/zipfs/ZipCoder.class");
		URL resource = extension.getResource("java/lang/String.class");
		try {
			InputStream inputStream = resource.openStream();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
