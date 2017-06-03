package ca.six.clean.domain.entity;

import java.util.Date;

public class Tweet {
    public String content;
    public Date time;
    public boolean isTech;
    public float rating;

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
        this.rating = getRating();
    }

    public float getRating() {
        int len = content.length();
        int techRate = isTech ? 1 : 0;
        rating = len / 4 + techRate;
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tweet tweet = (Tweet) o;

        if (isTech != tweet.isTech) return false;
        if (Float.compare(tweet.rating, rating) != 0) return false;
        if (!content.equals(tweet.content)) return false;
        return time.equals(tweet.time);

    }

    @Override
    public int hashCode() {
        int result = content.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + (isTech ? 1 : 0);
        result = 31 * result + (rating != +0.0f ? Float.floatToIntBits(rating) : 0);
        return result;
    }
}
