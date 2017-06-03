package ca.six.demo.rx.binding;

import android.support.annotation.CheckResult;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;

import io.reactivex.Observable;

public class Binds {
    @CheckResult
    public static Observable clicks(View v){
        return new ViewClickObservable(v);
    }

    @CheckResult
    public static Observable<MenuItem> nav(BottomNavigationView view){
        return new NavItemSelectObservable(view);
    }
}