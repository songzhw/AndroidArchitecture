package six.ca.dagger101.third.dagger

import dagger.Module
import dagger.Provides
import six.ca.dagger101.third.DbClient
import six.ca.dagger101.third.HttpClient

@Module
class CriticalModule {

    @Provides
    fun httpClient(): HttpClient {
        return HttpClient()
    }

    @Provides
    fun dbClient(): DbClient {
        return DbClient()
    }

}