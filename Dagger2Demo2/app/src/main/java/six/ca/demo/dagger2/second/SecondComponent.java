package six.ca.demo.dagger2.second;

import dagger.Component;

@Component(modules = SecondModule.class)
public interface SecondComponent {
    void inject(SecondDemo activity);
}
