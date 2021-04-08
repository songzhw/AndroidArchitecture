package cn.six.lab.dagger.core;

import javax.inject.Singleton;

import cn.six.lab.dagger.net.NetApis;
import cn.six.lab.dagger.net.NetApisModule;
import dagger.Component;

/**
 * Created by songzhw on 2016/3/21.
 */
@Singleton
@Component(modules = NetApisModule.class)
public interface AppComponent {
    NetApis getNetApis();
}
