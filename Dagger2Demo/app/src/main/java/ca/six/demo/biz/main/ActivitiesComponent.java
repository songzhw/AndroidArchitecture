package ca.six.demo.biz.main;

import dagger.Component;

@Component(modules = ActivitiesModule.class)
public interface ActivitiesComponent {
    void injectMain(MainActivity activity);
}
