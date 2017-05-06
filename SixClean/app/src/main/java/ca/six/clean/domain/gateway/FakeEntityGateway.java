package ca.six.clean.domain.gateway;

import java.util.ArrayList;
import java.util.List;

import ca.six.clean.domain.entity.Tweet;

public class FakeEntityGateway implements IEntityGateway {
    private List<Tweet> list;

    public FakeEntityGateway() {
        list = new ArrayList<>();
    }

    @Override
    public void createTweet(Tweet tweet) {
        list.add(tweet);
    }
}
