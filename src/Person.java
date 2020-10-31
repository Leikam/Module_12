import lombok.Data;
import lombok.NonNull;

@Data
public class Person {

    @NonNull
    private String name;
    @NonNull
    private int age;

}
