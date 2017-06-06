package ca.six.demo.dagger.cf_args;

import ca.six.demo.dagger.cf_args.data.TaskRepoModule;
import dagger.Component;

@Component(modules = {ForthViewModule.class, TaskRepoModule.class})
public interface ForthPresenterComponent {
    void inject(ForthActivity activity);
}