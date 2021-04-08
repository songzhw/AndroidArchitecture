package ca.six.todo.model;

import java.util.ArrayList;
import java.util.List;

import ca.six.util.L;

/**
 * Created by songzhw on 2016-05-14.
 */
public class FakeTaskManager implements ITaskManager {
    private List<Task> data = new ArrayList<>();

    private static FakeTaskManager instance;
    private FakeTaskManager(){}
    public static FakeTaskManager getInstance(){
        if(instance == null){
            instance = new FakeTaskManager();
        }
        return instance;
    }

    @Override
    public List<Task> getTasks() {
        return data;
    }

    @Override
    public void saveTask(String text) {
        data.add(new Task(text));
    }
}
