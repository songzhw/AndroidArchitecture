package ca.six.todo.datat;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import ca.six.todo.model.Task;
import ca.six.todo.model.TaskManager;
import ca.six.util.L;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by songzhw on 2016-05-15.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ModelTest {
    private TaskManager taskMgr;

    @Before
    public void setUp(){
        taskMgr = TaskManager.getInstance(
                InstrumentationRegistry.getTargetContext()
        );
    }

    @After
    public void cleanUp(){
        L.d("clear up");
        TaskManager.clear();
    }

    @Test
    public void testPreConditions() {
        assertNotNull(taskMgr);
    }

    @Test
    public void testSize(){
        L.d("pre");
        // When I write this test, I already added 5 tasks in the db
        assertEquals(5, taskMgr.getTasks().size());
    }


}
