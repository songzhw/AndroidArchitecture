package ca.six.clean.biz.add;

import ca.six.clean.domain.entity.Tweet;
import ca.six.clean.domain.usecase.AddTweetUseCase;

public class AddTweetPresenter {
    private IAddTweetView view;
    private AddTweetUseCase addTweetUseCase;

    public AddTweetPresenter(IAddTweetView view, AddTweetUseCase addTweetUseCase) {
        this.view = view;
        this.addTweetUseCase = addTweetUseCase;
    }

    public void save(String content, boolean isTech){
        Tweet tweet = new Tweet(content, isTech);
        addTweetUseCase.execute(tweet);
    }

    public void rate(String str, boolean isTech) {
        int len = str.length();
        int techRate = isTech ? 1 : 0;
        view.onRateChanged(len / 4 + techRate);
    }
}
