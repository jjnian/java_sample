package buffer;

import java.nio.ByteBuffer;


public class ByteBufferDemo {
    public static void main(String[] args) {

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println("-----------------------");

        // 写文件
        byteBuffer.put("hello".getBytes());
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println("-----------------------");

        System.out.println(new String(byteBuffer.array()));
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println("-----------------------");

        // 读文件
        byteBuffer.flip();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println("-----------------------");


    }
}
