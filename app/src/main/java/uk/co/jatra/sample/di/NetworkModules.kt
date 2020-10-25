package uk.co.jatra.sample.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import uk.co.jatra.sample.network.DogApi
import uk.co.jatra.sample.network.DogApiAdapter

@InstallIn(ApplicationComponent::class)
@Module
object NetworkModules {
    @Provides
    fun providesDogApi(): DogApi = DogApiAdapter.service
}