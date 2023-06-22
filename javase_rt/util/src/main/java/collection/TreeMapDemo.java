package collection;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeMap;

/**
 *
 */
public class TreeMapDemo {
	public static void main(String[] args) {
		TreeMap<String, String> sortedMap = new TreeMap<>(new NumericKeyComparator());
		sortedMap.put("24","bbb");
		sortedMap.put("10","aaa");
		sortedMap.put("33","ccc");
		Collection<String> values = sortedMap.values();
		for (String s : values){
			System.out.println(s);
		}
		System.out.println("----------------------------------");
		sortedMap.forEach((k,v)->{
			System.out.println(k + ":" + v);
		});
	}

	private static class NumericKeyComparator implements Comparator<String>{
		@Override
		public int compare(String key1, String key2) {
			// 将字符串转换为整数进行比较
			int num1 = Integer.parseInt(key1);
			int num2 = Integer.parseInt(key2);

			// 比较整数大小
			if (num1 < num2) {
				return -1;
			} else if (num1 > num2) {
				return 1;
			} else {
				return 0;
			}
		}
	}

}
