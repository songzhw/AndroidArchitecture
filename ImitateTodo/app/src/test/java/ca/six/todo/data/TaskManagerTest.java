package ca.six.todo.data;

import android.content.Context;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import ca.six.todo.model.TaskManager;

/**
 * Created by songzhw on 2016-05-15.
 */
public class TaskManagerTest {

    @Mock
    private TaskManager taskMgr;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void clear(){
    }

    @Test
    public void getTask_Call(){
        taskMgr.getTasks();
        verify(taskMgr).getTasks();
    }

}
