package ca.six.todo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import ca.six.todo.add_task.AddTaskActivity;
import ca.six.todo.add_task.AddTaskPresenter;
import ca.six.todo.model.ITaskManager;
import ca.six.todo.model.Task;

/**
 * Created by songzhw on 2016-05-16.
 */
public class AddTaskPresenterTest {
    private List<Task> data;
    private AddTaskPresenter presenter;
    @Mock
    public AddTaskActivity view;
    @Mock
    public ITaskManager model;

    @Before
    public void setUp(){
        data = new ArrayList<>();
        data.add(new Task("first"));
        data.add(new Task("task two"));

        MockitoAnnotations.initMocks(this);
        presenter = new AddTaskPresenter(view);
        presenter.model = model;

        Mockito.when(model.getTasks()).thenReturn(data);
    }

    @Test
    public void testAdd(){
        presenter.addTask("third");
        Mockito.verify(model).saveTask("third");
        Mockito.verify(view).finishAdd();
    }
}
