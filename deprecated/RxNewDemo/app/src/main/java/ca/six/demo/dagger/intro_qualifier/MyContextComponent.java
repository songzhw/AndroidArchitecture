package ca.six.demo.dagger.intro_qualifier;

import dagger.Component;

@Component(modules = MyContextModule.class)
public interface MyContextComponent {
    void inject(QualifierDemo activity);
}
