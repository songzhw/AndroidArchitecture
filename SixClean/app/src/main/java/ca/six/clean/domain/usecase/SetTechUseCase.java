package ca.six.clean.domain.usecase;

import ca.six.clean.domain.entity.Tweet;
import ca.six.clean.domain.gateway.IEntityGateway;

public class SetTechUseCase {
    private IEntityGateway gateway;

    public SetTechUseCase(IEntityGateway gateway) {
        this.gateway = gateway;
    }

    public void execute(Tweet tweet){

    }
}
