package ca.six.clean.biz.add;

import ca.six.clean.domain.entity.Tweet;
import ca.six.clean.domain.usecase.AddTweetUseCase;

public class AddTweetPresenter {
    private IAddTweetView view;
    private AddTweetUseCase addTweetUseCase;
    private Tweet tweet;

    public AddTweetPresenter(IAddTweetView view, AddTweetUseCase addTweetUseCase) {
        this.view = view;
        this.addTweetUseCase = addTweetUseCase;
    }

    public void save(String content, boolean isTech){
        Tweet tweet = new Tweet(content, isTech);
        addTweetUseCase.execute(tweet);
    }

    public void rate(String content, boolean isTech) {
        Tweet tweet = new Tweet(content, isTech);
        view.onRateChanged(tweet.getRating());
    }
}
