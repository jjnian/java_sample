package example1.output;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @Author ji_ruixin
 * @Date 2023/5/24
 */
public class PipedDemo {
	public static void main(String[] args) throws IOException {
		PipedInputStream in = new PipedInputStream();
		PipedOutputStream out = new PipedOutputStream();
		out.connect(in);
		Thread write = new Thread(()->{
			try {
				Thread.sleep(2000);
				out.write(97);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				try {
					out.flush();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});
		Thread read = new Thread(()->{
			try {
				System.out.println((char)in.read());
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});
		write.start();
		read.start();
	}
}
