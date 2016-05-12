package ca.six.todo.model;

/**
 * Created by songzhw on 2016-05-11.
 */
public class Task {
    public String content;
    public boolean isCompleted;

    /** for initilizing a task*/
    public Task(String text) {
        this(text, false);
    }

    /** for editing a existed task */
    public Task(String text, boolean isCompleted) {
        this.content = text;
        this.isCompleted = isCompleted;
    }

    @Override
    public String toString() {
        return "Task{" +
                "content='" + content + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
