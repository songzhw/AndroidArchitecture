package ca.six.demo.dagger.binds;

import dagger.Component;

@Component(modules = BindsModule.class)
public interface BindsComponent {
    void inject(BindsActivity activity);
}