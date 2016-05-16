package ca.six.todo;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import ca.six.todo.home.HomeActivity;
import ca.six.todo.home.HomePresenter;
import ca.six.todo.model.ITaskManager;
import ca.six.todo.model.Task;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by songzhw on 2016-05-16.
 */
public class HomePresenterTest {
    private List<Task> data;
    private HomePresenter presenter;
    @Mock
    private HomeActivity view;
    @Mock
    private ITaskManager model;

    @Before
    public void setUp(){
        data = new ArrayList<>();
        data.add(new Task("first"));
        data.add(new Task("task two"));


        MockitoAnnotations.initMocks(this);
        presenter = new HomePresenter(view);
        presenter.model = model;
        when(presenter.model.getTasks()).thenReturn(data);
    }

    @Test
    public void testPrecondition(){
        assertEquals(2, presenter.model.getTasks().size());
    }

    @Test
    public void testGet(){
        presenter.getTasks();
        assertEquals(2, presenter.model.getTasks().size());
        verify(view).showTasks(data);
    }
}
