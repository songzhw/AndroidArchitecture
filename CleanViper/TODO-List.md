 ✔ 1. CompositeDisposable放到一个Lifecycle插件中
    或是放到Di中去 (多个activity应该使用不同的吧)

 ✔ 2. RxJava的CompositeDisposable的清除要依赖生命周期, 导致RxCleanerInjected不能用于Presenter, 怎么办?
:
x 能否让presenter继承 LifeObservable?
x 或是让Activity使用presenter.lifecycleobservable (可能要用baseActv, basePresenter了)
✔ Activity把compositeDisposable传给Presenter

 ✔ 3. Retrofit如何根据status code来处理response?

4. 对于全局DI, 使用DepStore与InjectionInter是蛮好的
   但对于一些Presenter, Activity的注入, 我把 new LoginPresenter()写到单例 object SessionDepStore, 就有点过了. 毕竟我最后退出登录页, 想要销毁它的.
   => 所以这就是Dep的一个scope的问题
: 因为和生命周期相关, 所以我想可能还是要做一个LifeccyleOwner
Actv注册一个LifecycleOwner, owner提供presenter(可以由方法提供, 这样就是lazy提供),
其实不用LifecycleObserver也行, Android又不像Swift一样有循环引用问题 (Android用的是到达root的GC算法)
1). 要么把某Presenter的new, 放到全局DepStore中. 这时就得有LifecycleOwner来清空
2). 要么就是写到另一个类中, 只给Activity用. 这样就不用LifecycleOwner来清除了
=> 最终都是想简化new, 看来只能传入class, 用反射得到实例了, 问题就在于presneter.CF不能有参数. 这也是个弊端, 限制太死


