package ca.six.clean.domain.usecase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ca.six.clean.domain.entity.Tweet;
import ca.six.clean.domain.gateway.IEntityGateway;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class AddTweetUseCaseTest {
    @Mock IEntityGateway gateway;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void execute() throws Exception {
        AddTweetUseCase useCase = new AddTweetUseCase(gateway);
        Tweet tweet = new Tweet("test");
        useCase.execute(tweet);

        verify(gateway).createTweet(tweet);
    }

}