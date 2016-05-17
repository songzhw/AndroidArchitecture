package ca.six.todo;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.six.todo.model.ITaskManager;

/**
 * Created by songzhw on 2016-05-17.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class EnvironmentTest {
    @Test
    public void isDebugOrRelease(){
        // build variant? (release or debug) : debug !
        ITaskManager taskMgr = Injection.getModel(
                InstrumentationRegistry.getTargetContext()
        );
        Assert.assertEquals(3, taskMgr.getTasks().size());
    }
}
