package ca.six.demo.domain.entity;

public class User {
    public int id;
    public String name;

    public User(String name) {
        this.name = name;
        this.id = name.hashCode();
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
