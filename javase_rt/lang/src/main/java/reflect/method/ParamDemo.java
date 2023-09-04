package reflect.method;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ParamDemo {
    public static void main(String[] args) {
        try {
            Method test = ParamDemo.class.getMethod("test", String.class, Object.class);
            Parameter[] parameters = test.getParameters();
            for (Parameter parameter : parameters){
                System.out.println(parameter.getName());
                System.out.println(parameter.getType());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }


    public void test(String name, Object role){

    }
}
