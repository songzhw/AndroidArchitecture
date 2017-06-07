package ca.six.demo.dagger.scope;

import dagger.Component;

@Component
public interface ScopeComponent {
    void inject(DemoA actv);
}