package reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @Author ji_ruixin
 * @Date 2023/5/5
 */
public class Main {
	public static void main(String[] args) throws Exception{
		Class<?> at = Class.forName("AaaotationTest2");
		Field name = at.getDeclaredField("name");
		AaaotationTest2 aaaotationTest2 = new AaaotationTest2();
		System.out.println(name.getName()+name.getType());
		name.setAccessible(true);
		name.set(aaaotationTest2,"jiruixin");
		System.out.println(name.get(aaaotationTest2));
		System.out.println("-----------------------------------");
		AnnotationTest annotation = at.getAnnotation(AnnotationTest.class);
		System.out.println(annotation.value());
		System.out.println("-----------------------------------");
		Annotation[] annotations = at.getAnnotations();
		for(Annotation a : annotations) {
			Class aClass = a.annotationType();
			Field[] declaredFields = aClass.getDeclaredFields();
			for(Field f : declaredFields){
				System.out.println(f.getName());
				System.out.println(f.getType());
			}
		}

	}
}
