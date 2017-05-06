package ca.six.clean.domain.entity;

import java.util.Calendar;
import java.util.Date;

public class Tweet {
    public String content;
    public Date time;
    public boolean isTech;
    public int rating;

    public Tweet(String content) {
        this(content, false);
    }

    public Tweet(String content, boolean isTech) {
        this(content, new Date(), isTech);
    }

    public Tweet(String content, Date time, boolean isTech) {
        this.content = content;
        this.time = time;
        this.isTech = isTech;
        this.rating = 0; // TODO: 2017-05-06 change to a evaluation
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tweet tweet = (Tweet) o;

        if (isTech != tweet.isTech) return false;
        if (rating != tweet.rating) return false;
        if (!content.equals(tweet.content)) return false;
        return time.equals(tweet.time); //Date类自己有实现自己的equals()方法

    }

    @Override
    public int hashCode() {
        int result = content.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + (isTech ? 1 : 0);
        result = 31 * result + rating;
        return result;
    }
}
