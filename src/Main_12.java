import tasks.Code;
import tasks.DragAndDrop;
import tasks.Task;
import tasks.Test;

public class Main_12 {

    public static void main(String... args) {

        /* создаем задачи */
        Task[] tasks = new Task[40];
        for (int i =0; i < tasks.length; i++) {
            int rest = i % 3;
            if (rest == 0) {
                tasks[i] = new Code();
            } else if (rest == 1) {
                tasks[i] = new DragAndDrop();
            } else {
                tasks[i] = new Test();
            }
        }

        /* создаем пару менторов */
        Mentor mentor_vasya = new Mentor("Василий Петрович", 35);
        Mentor mentor_zhanna = new Mentor("Жанна Петрович", 29);

        /* создаем пул студентов */
        Student[] workingClass = new Student[20];
        for (int i = 0; i < workingClass.length; i++) {
            workingClass[i] = new Student("1", Utils.randomBetween(12, 101), mentor_vasya, false);
        }

        for (Student student : workingClass) {
            student.resolveTasks(Utils.randomIntInBounds(tasks.length), tasks);
        }

        System.out.print("\n\n\n=== КОНЕЦ ===");
        System.out.printf("\n=== Всего класс порешал %d задач ===\n", Student.resolvedTaskCounterByWorkingClass);
    }

}
