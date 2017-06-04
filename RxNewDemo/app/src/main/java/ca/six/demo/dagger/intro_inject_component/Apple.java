package ca.six.demo.dagger.intro_inject_component;

import javax.inject.Inject;

public class Apple {
    @Inject
    public Apple(){}

    @Override
    public String toString() {
        return "Good Apple";
    }
}
