package tasks;

public class DragAndDrop extends Task implements Autochecked {

    String[][] variants;

    public DragAndDrop() {
        super();
        this.variants = new String[][] {{"1", "2", "3"}, {"a", "b", "c"}};
    }
}
