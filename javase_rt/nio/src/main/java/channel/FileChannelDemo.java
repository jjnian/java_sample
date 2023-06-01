package channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Author ji_ruixin
 * @Date 2023/5/25
 */
public class FileChannelDemo {
	public static void main(String[] args) throws IOException {
		FileChannel fileChannel = FileChannel.open(Paths.get("file/text.txt"), StandardOpenOption.READ,StandardOpenOption.WRITE);
		ByteBuffer byteBuffer = ByteBuffer.allocate(10);

		// 写文件
		byteBuffer.put("hello".getBytes());
		// 通道把byteBuffer的数据写入到文件就需要读取byteBuffer里面的数据
		// 所以这里需要调用flip方法把byteBuffer变成读模式。
		// flip方法的读写相对于缓冲区而言，并不是针对通道而言。
		// 通道的写对应缓冲期的读。
		byteBuffer.flip();
		fileChannel.write(byteBuffer);

		// 读文件
		// 通道需要把从文件中读取的数据写入到缓冲区里，所以这需要用clear方法清空缓冲区
		// 通道的读对应缓冲期的写模式。
		byteBuffer.clear();
		fileChannel.read(byteBuffer);
		System.out.println(new String(byteBuffer.array()));

		fileChannel.close();
	}
}
