 ✔ 1. CompositeDisposable放到一个Lifecycle插件中
    或是放到Di中去 (多个activity应该使用不同的吧)

2. RxJava的CompositeDisposable的清除要依赖生命周期, 导致RxCleanerInjected不能用于Presenter, 怎么办?

3. 对于全局DI, 使用DepStore与InjectionInterfaces蛮好的
   但对于一些Presenter, Activity的注入, 我把 new LoginPresenter()写到单例 object SessionDepStore, 就有点过了. 毕竟我最后退出登录页, 想要销毁它的.
   => 所以这就是Dep的一个scope的问题

4. Retrofit如何根据status code来处理response?
