package ca.six.clean.biz.add;

import ca.six.clean.domain.entity.Tweet;
import ca.six.clean.domain.usecase.AddTweetUseCase;

public class AddTweetPresenter {
    private AddTweetUseCase addTweetUseCase;

    public AddTweetPresenter(AddTweetUseCase addTweetUseCase) {
        this.addTweetUseCase = addTweetUseCase;
    }

    public void save(String content, boolean isTech){
        Tweet tweet = new Tweet(content, isTech);
        addTweetUseCase.execute(tweet);
    }
}
