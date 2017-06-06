package ca.six.demo.dagger.cf_args;

import dagger.Component;

@Component (modules = ForthViewModule.class)
public interface ForthPresenterComponent {
    void inject(ForthActivity activity);
}