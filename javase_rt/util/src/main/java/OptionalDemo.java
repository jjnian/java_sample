import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        String name = null;

        Optional<String> name1 = Optional.ofNullable(name);
        if (name1.isPresent()){
            System.out.println("111");
        }else{
            System.out.println("2222");
        }

        Optional<String> name2 = Optional.of(name);
        if (name2.isPresent()){
            System.out.println("3333");
        }

    }
}
