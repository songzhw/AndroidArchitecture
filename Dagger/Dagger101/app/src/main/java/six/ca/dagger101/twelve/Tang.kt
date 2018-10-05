package six.ca.dagger101.twelve

import dagger.Component
import javax.inject.Inject

class Tang @Inject constructor(){}

@Component
interface TangComponent {
    fun inject(recevier: TangDemo)
}

