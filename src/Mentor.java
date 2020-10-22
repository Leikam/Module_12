import java.util.Random;

import tasks.Task;

public class Mentor extends Person implements Staff {

    private static final Random RANDOM = Utils.RANDOM; // несколько бесмысленно ввиду Utils, но что бы учесть требования задания
    private static final int GOOD_MOOD_LIMIT = 1000;

    boolean mood;

    public Mentor(String name, int age) {
        super(name, age);
        this.mood = true;
    }

    @Override
    public void helpStudent(Student student) {
        System.out.printf("\nМужайся %s сейчас-то еще ничего, дальше хуже будет!\n", student.getName());
    }

    public boolean checkTask(Task task) {
        this.mood = RANDOM.nextInt() > GOOD_MOOD_LIMIT;

        if (this.mood) {
            System.out.println("Клевое задание, клево решение и вообще клевый ты студент\n");
            return true;
        } else {
            System.out.printf("\nНет. Твой несчатливый номер %s (╯°□°）╯︵ ┻━┻\n", task.getNumber());
            return false;
        }

    }


}
