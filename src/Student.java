import tasks.Autochecked;
import tasks.Task;

public class Student extends Person {

    public static int resolvedTaskCounterByWorkingClass;

    private int resolvedTaskCounter;
    private Mentor mentor;
    private boolean allTasksResolved;


    public Student(String name, int age, Mentor mentor, boolean isAllTasksSolved) {
        super(name, age);
        this.mentor = mentor;
        this.allTasksResolved = isAllTasksSolved;
    }

    public void resolveTasks(int taskToResolveCounter, Task[] taskArray) {
        if (this.allTasksResolved) {
            System.out.println("[%s] Все задачи уже решены! (งツ)ว");
        } else {
            for (int i = resolvedTaskCounter; i < taskArray.length; i++) {
                Task currentTask = taskArray[i];
                resolveTask(currentTask);
            }

            this.setAllTasksResolved(this.resolvedTaskCounter == taskToResolveCounter);

            if (isAllTasksResolved()) {
                System.out.printf("[%s] Все задачи решены, задач больше нет.", getName());
            } else {
                System.out.printf("[%s] Ну надо еще постараться", getName());
            }
        }
    }

    private void resolveTask(Task task) {
        if (task instanceof Autochecked) {
            ((Autochecked) task).resolveTask();
        } else {
            /* Надеюсь с ментором ничего не произойдет */
            while (!getMentor().checkTask(task));

            this.resolvedTaskCounter++;
            Student.resolvedTaskCounterByWorkingClass++;
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

    public boolean isAllTasksResolved() {
        return allTasksResolved;
    }

    public void setAllTasksResolved(boolean allTasksResolved) {
        this.allTasksResolved = allTasksResolved;
    }
}
