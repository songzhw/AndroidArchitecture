package six.ca.demo.dagger2.simple;

import javax.inject.Inject;

/**
 * Created by songzhw on 2017-06-02.
 */

public class Apple {
    @Inject
    public Apple(){}

    @Override
    public String toString() {
        return "Good Apple";
    }
}
