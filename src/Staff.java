public interface Staff {

    void helpStudent(Student student);

    default void sendMoreInformation() {
        System.out.println("https://habr.com/ru/");
    }
}
