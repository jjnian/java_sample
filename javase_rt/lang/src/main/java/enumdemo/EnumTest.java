package enumdemo;
/**
 *  1.枚举的构造方法私有，构造器只能使用 private 访问修饰符。
 *
 * 	2.枚举类的所有实例(枚举值)必须在枚举类的第一行显式地列出，
 * 	系统会自动添加 public static final 修饰。
 */
public enum  EnumTest {

	JI("111"),

	RUI("222"),

	XIN("13311");

	private final String name;

	EnumTest(String s) {
		this.name = s;
	}

	public String getName() {
		return name;
	}
}
