package ca.six.demo.dagger.scope;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = UserModel.class)
public interface ScopeComponent {
    void inject(DemoA actv);
}