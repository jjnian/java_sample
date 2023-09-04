import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.LinkedList;

/**
 *
 */
public class MemoryDemo {

	public static void main(String[] args) {
		MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
		MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();

		System.out.println("Heap Memory:");
		System.out.println("Used:" + (heapMemoryUsage.getUsed()) + "byte");
		System.out.println("Committed:" + (heapMemoryUsage.getCommitted()) + "byte");
		System.out.println("Max:" + (heapMemoryUsage.getMax()) + "byte");

		System.out.println("-------------------------------------");
		long maxMemory = Runtime.getRuntime().maxMemory();
		long totalMemory = Runtime.getRuntime().totalMemory();
		long freeMemory = Runtime.getRuntime().freeMemory();
		System.out.println("可以获得最大内存是："+ maxMemory + "byte");
		System.out.println("已分配到的内存大小是："+ totalMemory + "byte");
		System.out.println("所分配内存的剩余大小是："+ freeMemory + "byte");

		String a = "111";
		LinkedList<String> strings = new LinkedList<>();
		while(true){
			strings.add(a);
		}
	}
	
}
