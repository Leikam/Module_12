package tasks;

public interface Autochecked {
    default void resolveTask() {
        System.out.print("Задача выполнена!");
    }
}
