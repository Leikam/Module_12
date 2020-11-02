import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import tasks.Code;
import tasks.DragAndDrop;
import tasks.Task;
import tasks.Test;

public class Main_12 {

    public static void main(String... args) {
        Calendar calendar = Calendar.getInstance();

        /* создаем задачи */
        Task[] tasks = new Task[40];
        for (int i =0; i < tasks.length; i++) {
            switch (RandomUtils.randomBetween(1, 3)) {
                case 1 -> tasks[i] = new Code();
                case 2 -> tasks[i] = new DragAndDrop();
                case 3 -> tasks[i] = new Test();
            }
            tasks[i].setNumber(i);
        }

        /* создаем несколько менторов */
        Mentor[] mentors = new Mentor[] {
            new Mentor("Василий Петрович", 35),
            new Mentor("Жанна Петрович", 29),
            new Mentor("просто Петя", 23),
        };

        /* создаем пул студентов c именами в честь месяца */
        Student[] workingClass = new Student[21];
        for (int i = 0; i < workingClass.length; i++) {
            calendar.set(Calendar.MONTH, RandomUtils.randomIntInBounds(11));
            workingClass[i] = new Student(
                getStudentName(calendar),
                RandomUtils.randomBetween(12, 101),
                mentors[RandomUtils.randomIntInBounds(2)],
                false
            );
        }

        for (Student student : workingClass) {
            student.resolveTasks(RandomUtils.randomIntInBounds(tasks.length), tasks);
        }

        System.out.printf("\n\n=== Всего класс порешал %d задач ===\n\n", Student.resolvedTaskCounterByWorkingClass);
        System.out.print("=== КОНЕЦ ===");
    }

    private static String getStudentName(Calendar calendar) {
        String name = new SimpleDateFormat("MMMM", new Locale("RU")).format(calendar.getTime());
        return String.valueOf(name.charAt(0)).toUpperCase() + name.substring(1);
    }

}
