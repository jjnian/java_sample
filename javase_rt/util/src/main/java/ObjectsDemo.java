import java.util.Objects;

public class ObjectsDemo {

    public static void main(String[] args) {
        String name = null;

        if(Objects.isNull(name)){
            System.out.println("111");
        }else{
            System.out.println("2222");
        }

    }

}
