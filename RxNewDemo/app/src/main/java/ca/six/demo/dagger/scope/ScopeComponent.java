package ca.six.demo.dagger.scope;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component
public interface ScopeComponent {
    void inject(DemoA actv);
}