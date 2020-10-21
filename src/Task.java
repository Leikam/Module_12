public class Task {

    private boolean autotested;

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    private boolean resolved;

    public boolean isAutotested() {
        return this.autotested;
    }

    public boolean isResolved() {
        return this.resolved;
    }
}
