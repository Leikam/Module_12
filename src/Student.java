import org.w3c.dom.ls.LSOutput;

public class Student extends Person {

    public static int solvedTaskCounterByAll;

    private int solvedTaskCounter;
    private Mentor mentor;
    private boolean allTasksSolved;


    public Student(String name, int age, Mentor mentor, boolean isAllTasksSolved) {
        super(name, age);
        this.mentor = mentor;
        this.allTasksSolved = isAllTasksSolved;
    }

    public void resolveTasks(int taskToResolveCounter, Task[] taskArray) {
        if (!this.allTasksSolved) {
            int resolvedInSession = 0;
            for (int i = solvedTaskCounter; i < taskArray.length; i++) {
                Task currentTask = taskArray[i];
                resolveTask(currentTask);
                if (currentTask.isResolved()) {
                    resolvedInSession++;
                }
            }

            if (resolvedInSession == taskToResolveCounter) {
                this.setAllTasksSolved(true);
                System.out.print("Все задачи решены, задач больше нет.");
            } else {
                System.out.print("Ну надо еще постараться");
                this.setAllTasksSolved(false);
            }
        } else {
            System.out.println("Все задачи уже решены! (งツ)ว");
        }
    }

    private void resolveTask(Task task) {
        if (!task.isAutotested()) {

            while (!task.isResolved()) {
                /* возможно хотим немного Thread.sleep() что бы не за досить ментора */
                getMentor().checkTask(task);
            }

            this.solvedTaskCounter++;
            Student.solvedTaskCounterByAll++;
        }

        System.out.println("Задание выполнено");
    }

    public int getSolvedTaskCounter() {
        return solvedTaskCounter;
    }

    public void setSolvedTaskCounter(int solvedTaskCounter) {
        this.solvedTaskCounter = solvedTaskCounter;
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
