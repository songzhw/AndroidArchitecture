package six.ca.dagger101.first

import dagger.Component

@Component
interface SimpleComponent {
    fun inject(activity: SimpleDemo)
}