package ca.six.demo.dagger.scope;

import android.app.Application;


public class ScopeApp extends Application {
    ScopeComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerScopeComponent.builder()
                .userModel(new UserModel())
                .build();
    }

    public ScopeComponent getScopeComponent() {
        return component;
    }
}
