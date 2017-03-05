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

public class AddTaskViewModel {
    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> desp = new ObservableField<>();

    public void addedNewTask(View v) {
        ToRequest req = new ToRequest();
        req.addParam("name", name.get());
        req.addParam("desp", desp.get());
        req.sendRequest("58bc38f61000005118109ec8", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {}
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("szw addTask Response = " + response.body().string());
            }
        });
    }

}
