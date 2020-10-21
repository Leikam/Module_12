public class Mentor extends Person {
    
    public Mentor(String name, int age) {
        super(name, age);
    }

    public void checkTask(Task task) {
        task.setResolved(true);
    }
}
