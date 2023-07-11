package collection.list;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 */
public class ListDemo {
	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<>();
		strings.add("1");
		strings.add("2");
		System.out.println(strings.size());
		// 清空list
		strings.removeAll(strings);
		System.out.println(strings.size());

		// 双括号初始价一个列表
		LinkedList<String> strings1 = new LinkedList<String>() {{
			add("111");
			add("222");
			add("333");
		}};
		System.out.println(strings1.size());
		System.out.println(strings1.get(0));
	}
}
