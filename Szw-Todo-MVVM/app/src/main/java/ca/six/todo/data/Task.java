package ca.six.todo.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by songzhw on 2017-03-04
 */

public class Task {
    public long id;
    public String name;
    public String desp;
    public boolean isFinished;

    public Task(long id, String name, String desp, boolean isFinished) {
        this.id = id;
        this.name = name;
        this.desp = desp;
        this.isFinished = isFinished;
    }

}
