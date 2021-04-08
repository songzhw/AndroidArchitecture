package ca.six.demo.dagger.intro_inject_component;

import dagger.Component;

@Component
public interface SimpleComponent {
    void inject(SimpleDemo activity);
}
