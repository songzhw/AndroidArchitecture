1. Error : A @Module may not contain both non-static @Provides method and abstract @Binds or @Multibinds declarations
```java
@Module
public abstract class BindsModule {
    @Binds
    abstract IBindsView getBindsView(BindsActivity activity);

    @Provide
    public User getUser(){
        return new User();
    }
}
```