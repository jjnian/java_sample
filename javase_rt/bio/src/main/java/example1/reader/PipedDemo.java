package example1.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @Author ji_ruixin
 * @Date 2023/5/24
 */
public class PipedDemo {
	public static void main(String[] args) throws IOException {
		PipedReader in = new PipedReader();
		PipedWriter out = new PipedWriter();
		in.connect(out);
		Thread write = new Thread(()->{
			try {
				Thread.sleep(2000);
				out.write("我是PipedWriter");
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
				BufferedReader bufferedReader = new BufferedReader(in);
				System.out.println(bufferedReader.readLine());
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
