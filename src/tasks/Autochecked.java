package tasks;

public interface Autochecked {
    default void resolveTask() {
        System.out.println("Задача выполнена!\n");
    }
}
