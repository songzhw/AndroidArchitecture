package ca.six.demo.cleanviper.core.di

import ca.six.demo.cleanviper.core.http.HttpService

interface HttpInjected {
    val http: HttpService
        get() = DepStore.http
}