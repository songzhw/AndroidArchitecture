package ca.six.clean.biz.add;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ca.six.clean.domain.entity.Tweet;
import ca.six.clean.domain.usecase.AddTweetUseCase;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AddTweetPresenterTest {
    @Mock IAddTweetView view;
    @Mock AddTweetUseCase useCase;
    @Captor ArgumentCaptor<Tweet> captor;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void save() throws Exception {
        AddTweetPresenter presenter = new AddTweetPresenter(view, useCase);

        presenter.save("test", true);

        // Tweet创建是会用new Date()， 所以不能直接比较Tweet对象。 得用ArgumentCaptor
        verify(useCase).execute(captor.capture());

        Tweet realTweet = captor.getValue();
        assertEquals("test", realTweet.content);
        assertEquals(true, realTweet.isTech);
    }

}