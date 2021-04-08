package cn.six.lab.dagger.data;

/**
 * Created by songzhw on 2016/3/21.
 */
public class Repo {
    public long id;
    public String name;
    public int size;

    @Override
    public String toString() {
        return "Repo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
