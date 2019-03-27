package ca.six.rxdemo;

import io.reactivex.Flowable;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Temp {
  private void fun(){
    Observable<Long> one = Observable.interval(2, TimeUnit.SECONDS);
    Observable<Long> two = Observable.interval(3, TimeUnit.SECONDS);
    Observable.merge(one, two)
        .subscribe();
  }
}
