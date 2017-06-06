package ca.six.demo.dagger.cf_arg;

import dagger.Component;

@Component
public interface SamplePresenterComponent {
    void inject(SampleActivity activity);
}