package ca.six.todo.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by songzhw on 2017-03-04
 */

public class Task {
    public String name;
    public String desp;
    public boolean isFinished;

    public Task(String name, String desp, boolean isFinished) {
        this.name = name;
        this.desp = desp;
        this.isFinished = isFinished;
    }

}
