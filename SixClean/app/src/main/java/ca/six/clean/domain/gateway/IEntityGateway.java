package ca.six.clean.domain.gateway;

import java.util.List;

import ca.six.clean.domain.entity.Tweet;

public interface IEntityGateway {
    void createTweet(Tweet tweet);
    void updateTweet(Tweet newTweet);
}
