package ca.six.demo.dagger.cf_args.data;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;

public class TaskRepo implements IDataSource {

    private IDataSource local;
    private IDataSource server;

    @Inject
    public TaskRepo(@LocalRepo IDataSource local, @RemoteRepo IDataSource server) {
        this.local = local;
        this.server = server;
    }

    @Override
    public List<String> getNames() {
        int flag = new Random().nextInt(100);
        if (flag % 2 == 0) {
            return local.getNames();

        }
        return server.getNames();
    }
}
