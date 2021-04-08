package ca.six.demo.dagger.intro_module;

import dagger.Component;

@Component(modules = SecondModule.class)
public interface SecondComponent {
    void inject(SecondDemo activity);
}
