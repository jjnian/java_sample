package tcpchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ssc.bind(new InetSocketAddress(10005));
        Selector open = Selector.open();
        ssc.register(open, SelectionKey.OP_ACCEPT);

        while(open.select()>0){
            Set<SelectionKey> selectionKeys = open.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey next = iterator.next();
                if (next.isAcceptable()){
                    SocketChannel accept = ssc.accept();
                    accept.configureBlocking(false);
                    accept.register(open,SelectionKey.OP_READ);
                }else if(next.isReadable()){
                    SocketChannel channel = (SocketChannel)next.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(10);
                    channel.read(byteBuffer);
                    String s = new String(byteBuffer.array());
                    System.out.println("接收的消息是：" + s);
                    if ("886".equals(s.trim())){channel.close();break;}
                    byteBuffer.flip();
                    channel.write(byteBuffer);
                    // byteBuffer.clear();
                }
                iterator.remove();
            }
        }


    }
}
