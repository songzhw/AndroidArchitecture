package ca.six.demo.rx.binding;

import android.support.annotation.CheckResult;
import android.view.View;

import io.reactivex.Observable;

public class Binds {
    @CheckResult
    public static Observable clicks(View v){
        return new ViewClickObservable(v);
    }
}