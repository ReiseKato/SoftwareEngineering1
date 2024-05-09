import java.io.Serializable;

public class Task implements Serializable {
    private String task;
    private int taskId;
    private int userStoryId;

    public Task(String task, int id) {
        this.task = task;
        this.taskId = id;
    }

    public int getUserStoryId() {
        return userStoryId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setUserStoryId(int id) {
        this.userStoryId = id;
    }

    public String toString() {
        return "Task ID: " + this.taskId + " - Beschreibung: " + this.task;
    }
}
