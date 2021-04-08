package six.ca.dagger101.six

import dagger.Component
import javax.inject.Singleton

@Component
@Singleton
interface SongComponent {
    fun inject(receiver: SixDemo)
}