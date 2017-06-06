package ca.six.demo.dagger.cf_args.data;

import java.util.List;
import java.util.Random;

public class TaskRepo implements IDataSource {

    private IDataSource local;
    private IDataSource server;

    public TaskRepo(IDataSource local, IDataSource server) {
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
