package ca.six.demo.dagger.cf_arg;

import dagger.Component;

@Component (modules = SampleViewModule.class)
public interface SamplePresenterComponent {
    void inject(SampleActivity activity);
}