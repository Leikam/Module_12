package tasks;

public class Test extends Task implements Autochecked {

    String[] answers;

    public Test() {
        this.answers =  new String[] {"a", "b", "c"};
    }
}
