package ca.six.todo.biz.add_task;

import android.databinding.ObservableField;
import android.view.View;

import java.io.IOException;

import ca.six.todo.model.ToRequest;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by songzhw on 2017-03-05
 */
public class AddTaskViewModel implements Callback {
    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> desp = new ObservableField<>();

    private IAddTaskView view;
    public ToRequest req;

    public AddTaskViewModel(IAddTaskView view){
        this.view = view;
        req = new ToRequest();
    }

    public void addedNewTask(View v) {
        req.addParam("name", name.get());
        req.addParam("desp", desp.get());
        req.sendRequest(ToRequest.ADD_TASK_URL, this);
    }

    @Override
    public void onFailure(Call call, IOException e) {
        view.addedFailed();
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        if(response != null) {
            System.out.println("szw addTask Response = " + response.body().string());
        }
        view.addedTask(name.get(), desp.get());
    }

}
