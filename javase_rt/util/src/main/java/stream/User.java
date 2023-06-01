package stream;

/**
 * @Author ji_ruixin
 * @Date 2023/6/1
 */
public class User{
	private int order;

	private String name;

	private int age;

	private String address;

	public User(int order, String name, int age, String address) {
		this.order = order;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
