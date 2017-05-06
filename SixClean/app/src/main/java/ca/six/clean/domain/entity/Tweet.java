package ca.six.clean.domain.entity;

import java.util.Calendar;

public class Tweet {
    public String content;
    public Calendar time;
    public boolean isTech;
    public int rating;

    public Tweet(String content) {
        this(content, Calendar.getInstance(), false);
    }

    public Tweet(String content, boolean isTech) {
        this(content, Calendar.getInstance(), isTech);
    }

    public Tweet(String content, Calendar time, boolean isTech) {
        this.content = content;
        this.time = time;
        this.isTech = isTech;
        this.rating = 0; // TODO: 2017-05-06 change to a evaluation
    }
}
