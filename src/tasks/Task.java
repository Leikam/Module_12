package tasks;

public abstract class Task {

    private int number;
    private String subject;

    public Task() {
        this.number = 0;
        this.subject = "некоторое описание";
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getNumber() {
        return this.number;
    }
}
