package ca.six.demo.rx.binding;


import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import ca.six.demo.rx.utils.MyUtils;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/**
 * Created by songzhw on 2017-06-03.
 */

public class NavItemSelectObservable extends Observable<MenuItem> {
    private final BottomNavigationView view;

    public NavItemSelectObservable(BottomNavigationView v) {
        this.view = v;
    }

    @Override
    protected void subscribeActual(Observer<? super MenuItem> observer) {
        if (!MyUtils.isMainThread()) {
            return;
        }

        SelectListener listener = new SelectListener(view, observer);
        observer.onSubscribe(listener);
        view.setOnNavigationItemSelectedListener(listener);

        Menu menu = view.getMenu();
    }


    private class SelectListener extends MainThreadDisposable implements BottomNavigationView.OnNavigationItemSelectedListener {
        private BottomNavigationView  view;
        private Observer<? super MenuItem> observer;

        public SelectListener(BottomNavigationView view, Observer<? super MenuItem> observer) {
            this.view = view;
            this.observer = observer;
        }

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            if(isDisposed()){
                return true;
            }

            observer.onNext(item);
            return true;
        }

        @Override
        protected void onDispose() {
            view.setOnNavigationItemSelectedListener(null);
        }
    }

}
