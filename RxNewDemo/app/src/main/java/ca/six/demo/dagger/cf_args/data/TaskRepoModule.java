package ca.six.demo.dagger.cf_args.data;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class TaskRepoModule {

    @Binds
    @LocalRepo
    abstract IDataSource getLocalRepo(LocalTaskRepo dataSource);

    @Binds
    @LocalRepo
    abstract IDataSource getRemoteRepo(RemoteTaskRepo dataSource);
   
}