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
            System.out.print("\n[%s] Все задачи уже решены! (งツ)ว\n");
        } else {
            int tasksToResolve = Math.min(taskArray.length, taskToResolveCounter);
            for (int i = resolvedTaskCounter; i < tasksToResolve; i++) {
                Task currentTask = taskArray[i];
                resolveTask(currentTask);
            }

            this.setAllTasksResolved(this.resolvedTaskCounter == taskToResolveCounter);

            if (isAllTasksResolved()) {
                System.out.printf("\n[%s] Все задачи решены, задач больше нет.\n", getName());
            } else {
                System.out.printf("\n[%s] Не все задачи решены, надо еще постараться\n", getName());
            }
        }
    }

    private void resolveTask(Task task) {
        if (task instanceof Autochecked) {
            ((Autochecked) task).resolveTask();
        } else {
            /* Надеюсь с ментором ничего не произойдет */
            while (!getMentor().checkTask(task));
        }

        this.resolvedTaskCounter++;
        Student.resolvedTaskCounterByWorkingClass++;
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
