public class Task {
    private int id;
    private String title;
    private String description;
    private boolean isCompleted;

    Task(String title, String description, boolean isCompleted) {
        this.title = title;
        this.description = description;
        this.isCompleted = isCompleted;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setComplete() {
        isCompleted = true;
    }

    public boolean getComplete() {
        return isCompleted;
    }
}
