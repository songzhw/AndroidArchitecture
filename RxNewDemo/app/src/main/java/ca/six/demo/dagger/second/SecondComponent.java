package ca.six.demo.dagger.second;

import dagger.Component;

@Component(modules = SecondModule.class)
public interface SecondComponent {
    void inject(SecondDemo activity);
}
