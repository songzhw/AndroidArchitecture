package ca.six.todo.biz.add_task;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import ca.six.todo.model.ToRequest;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by songzhw on 2017-03-05
 */
public class AddTaskViewModelTest {
    @Captor
    private ArgumentCaptor<Callback> captor;
    @Mock
    private IAddTaskView view;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addedNewTask_Succ() throws Exception {
        AddTaskViewModel vm = new AddTaskViewModel(view);
        ToRequest req = mock(ToRequest.class);
        vm.req = req;

        vm.addedNewTask(null);

        verify(req).sendRequest(anyString(), captor.capture());
        captor.getValue().onResponse(any(Call.class), any(Response.class));

        verify(view).addedTask(anyString(), anyString());
    }

    @Test
    public void addedNewTask_Fail() throws Exception {
        AddTaskViewModel vm = new AddTaskViewModel(view);
        ToRequest req = mock(ToRequest.class);
        vm.req = req;

        vm.addedNewTask(null);

        verify(req).sendRequest(anyString(), captor.capture());
        captor.getValue().onFailure(null, null);

        verify(view).addedFailed();
    }
}