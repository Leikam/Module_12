import java.util.Random;

import tasks.Task;

public class Mentor extends Person implements Staff {

    private static final int GOOD_MOOD_LIMIT = 1000;

    boolean mood;

    public Mentor(String name, int age) {
        super(name, age);
        this.mood = true;
    }

    @Override
    public void helpStudent(Student student) {
        System.out.printf("\nМужайся, %s, сейчас это еще ничего, дальше хуже будет!\n", student.getName());
    }

    public boolean checkTask(Task task) {
        this.mood = RandomUtils.random() > GOOD_MOOD_LIMIT;

        if (this.mood) {
            System.out.print("\nВсе решено по-царски\n");
            return true;
        } else {
            System.out.printf("\nЗадача №%s не принята, (╯°□°）╯︵ ┻━┻\n", task.getNumber());
            return false;
        }

    }


}
