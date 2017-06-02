package six.ca.demo.dagger2.simple;

import dagger.Component;

/**
 * Created by songzhw on 2017-06-02.
 */
@Component
public interface SimpleComponent {
    void inject(SimpleDemo activity);
}
