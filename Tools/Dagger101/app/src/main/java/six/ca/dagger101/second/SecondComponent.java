package six.ca.dagger101.second;

import dagger.Component;

@Component(modules = SecondModule.class)
public interface SecondComponent {
    void inject(SecondDemo activity);
}