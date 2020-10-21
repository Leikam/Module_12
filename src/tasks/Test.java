package tasks;

public class Test extends Task implements Autochecked {

    String[] answers;

    public Test() {
        super();
        this.answers =  new String[] {"a", "b", "c"};
    }
}
