package ca.six.clean.domain.usecase;

import ca.six.clean.domain.entity.Tweet;
import ca.six.clean.domain.gateway.IEntityGateway;

public class AddTweetUseCase {
    private IEntityGateway gateway;

    public AddTweetUseCase(IEntityGateway gateway) {
        this.gateway = gateway;
    }

    public void execute(Tweet tweet){
        gateway.createTweet(tweet);
    }
}
