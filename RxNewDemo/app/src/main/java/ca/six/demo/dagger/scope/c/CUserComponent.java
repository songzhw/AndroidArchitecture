package ca.six.demo.dagger.scope.c;

import dagger.Component;

@Component(modules = CUserModel.class)
public interface CUserComponent {
    void inject(DemoC actv);
}
