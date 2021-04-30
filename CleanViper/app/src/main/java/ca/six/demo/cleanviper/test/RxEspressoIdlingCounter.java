package ca.six.demo.cleanviper.test;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.idling.CountingIdlingResource;

// TODO 是否要在合适时机调用 IdlingRegistry的unregister() ?
public class RxEspressoIdlingCounter {
    private CountingIdlingResource counter;

    private static RxEspressoIdlingCounter instance = new RxEspressoIdlingCounter();

    private RxEspressoIdlingCounter() {
        counter = new CountingIdlingResource("RxEspressoIdlingCounter");
        IdlingRegistry.getInstance().register(counter);
    }

    public static void increase() {
        instance.counter.increment();
    }

    public static void decrease() {
        instance.counter.decrement();
    }

    public static boolean isIdleNow() {
        return instance.counter.isIdleNow();
    }

}

// 网上的 Espressso.registerIdlingResources(counter) 已经被deprecated了. 推荐使用IdingRegistry


