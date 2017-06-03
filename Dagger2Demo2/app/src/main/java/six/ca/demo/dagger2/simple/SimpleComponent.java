package six.ca.demo.dagger2.simple;

import dagger.Component;

@Component
public interface SimpleComponent {
    void inject(SimpleDemo activity);
}
