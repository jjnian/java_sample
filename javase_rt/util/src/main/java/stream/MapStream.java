package stream;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ji_ruixin
 * @Date 2023/6/1
 */
public class MapStream {
	public static void main(String[] args) {
		LinkedList<User> userList = new LinkedList<>();

		userList.add(new User(5,"张超",15,"深圳"));
		userList.add(new User(6,"李雷",24,"北京"));
		userList.add(new User(7,"王爷",21,"上海"));
		userList.add(new User(8,"张三丰",18,"广州"));
		userList.add(new User(9,"赵六",16,"广州"));
		userList.add(new User(10,"赵无极",26,"深圳"));
		userList.add(new User(1,"张三",18,"上海"));
		userList.add(new User(2,"王五",16,"上海"));
		userList.add(new User(3,"李四",20,"上海"));
		userList.add(new User(4,"张雷",22,"北京"));


		// 当Lambda表示中只有一行语句时可以不用return，但必须是布尔类型
		// 当加上{}时就需要return 布尔类型
		List<User> collect = userList.stream()
				.filter(user -> {user.getOrder();return true;})
				.collect(Collectors.toList());

		// 当Lambda表示中只有一行语句时可以不用return，
		// 当加上{}时就需要return一个值
		List<User> collect1 = userList.stream()
				.map(user -> {user.setAge(user.getAge()+10);return user;})
				.limit(7)
				// 可以给比较的类实现Comparable这个接口，自己实现比较逻辑
				.sorted(Comparator.comparing(user -> user.getOrder()))
				.collect(Collectors.toList());

		// peer不需要返回值，不会产生新的流。
		List<User> collect2 = userList.stream()
				.limit(3)
				.peek(user -> {user.setAge(user.getAge()+10);})
				.collect(Collectors.toList());

	}
}
