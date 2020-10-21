import tasks.Task;

public class Student extends Person {

    public static int solvedTaskCounterByAll;

    private int resolvedTaskCounter;
    private Mentor mentor;
    private boolean allTasksSolved;


    public Student(String name, int age, Mentor mentor, boolean isAllTasksSolved) {
        super(name, age);
        this.mentor = mentor;
        this.allTasksSolved = isAllTasksSolved;
    }

    public void resolveTasks(int taskToResolveCounter, Task[] taskArray) {
        if (!this.allTasksSolved) {
            for (int i = resolvedTaskCounter; i < taskArray.length; i++) {
                Task currentTask = taskArray[i];
                resolveTask(currentTask);
            }

            this.setAllTasksSolved(this.resolvedTaskCounter == taskToResolveCounter);

            if (isAllTasksSolved()) {
                System.out.print("Все задачи решены, задач больше нет.");
            } else {
                System.out.print("Ну надо еще постараться");
            }
        } else {
            System.out.println("Все задачи уже решены! (งツ)ว");
        }
    }

    private void resolveTask(Task task) {
        if (task.isAutotested()) {
            System.out.println("Задание выполнено");

        } else {
            /* Надеюсь с ментором ничего не произойдет */
            while (!getMentor().checkTask(task));

            this.resolvedTaskCounter++;
            Student.solvedTaskCounterByAll++;
        }
    }

    public int getResolvedTaskCounter() {
        return resolvedTaskCounter;
    }

    public void setResolvedTaskCounter(int resolvedTaskCounter) {
        this.resolvedTaskCounter = resolvedTaskCounter;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public boolean isAllTasksSolved() {
        return allTasksSolved;
    }

    public void setAllTasksSolved(boolean allTasksSolved) {
        this.allTasksSolved = allTasksSolved;
    }
}
