package ca.six.demo.rx.binding;

import android.view.View;

import ca.six.demo.rx.utils.MyUtils;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;


public class ViewClickObservable extends Observable<Object> {
    private final View view;

    public ViewClickObservable(View view) {this.view = view;}

    // Observable is an abstract method, you need to override this method.
    @Override
    protected void subscribeActual(Observer<? super Object> observer) {
        if (!MyUtils.isMainThread()) {
            return;
        }

        ClickListener listener = new ClickListener(view, observer);
        observer.onSubscribe(listener);
        view.setOnClickListener(listener);
    }

    // 网上的MainThreadSubscription， 现在是改为MainThreadDisposable了
    private class ClickListener extends MainThreadDisposable implements View.OnClickListener{
        private View view;
        private Observer observer;

        public ClickListener(View view, Observer observer) {
            this.view = view;
            this.observer = observer;
        }

        // <-- OnClickListener
        @Override
        public void onClick(View v) {
            if( !isDisposed() ){
                observer.onNext(0);
            }
        }

        // <-- MainThreadDisposable
        @Override
        protected void onDispose() {
            view.setOnClickListener(null);
        }
    }

}

