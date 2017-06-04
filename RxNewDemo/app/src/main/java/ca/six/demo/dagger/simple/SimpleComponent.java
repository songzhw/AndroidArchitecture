package ca.six.demo.dagger.simple;

import dagger.Component;

@Component
public interface SimpleComponent {
    void inject(SimpleDemo activity);
}
