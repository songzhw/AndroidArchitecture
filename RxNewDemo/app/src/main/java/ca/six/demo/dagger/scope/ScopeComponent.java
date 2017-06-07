package ca.six.demo.dagger.scope;

import javax.inject.Singleton;

import dagger.Component;

@UserScope
@Component(modules = UserModel.class)
public interface ScopeComponent {
    void inject(DemoA actv);
    void inject(DemoB actv);
}