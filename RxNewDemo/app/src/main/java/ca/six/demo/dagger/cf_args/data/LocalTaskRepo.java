package ca.six.demo.dagger.cf_args.data;

import java.util.ArrayList;
import java.util.List;

public class LocalTaskRepo implements IDataSource {
    @Override
    public List<String> getNames() {
        List<String> ret = new ArrayList<>();
        ret.add("local");
        ret.add("local2");
        return ret;
    }
}
