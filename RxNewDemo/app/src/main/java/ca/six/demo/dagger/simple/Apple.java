package ca.six.demo.dagger.simple;

import javax.inject.Inject;

public class Apple {
    @Inject
    public Apple(){}

    @Override
    public String toString() {
        return "Good Apple";
    }
}
