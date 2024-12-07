package vn.finance.profile.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import vn.finance.profile.api.ProfileApi
import vn.finance.profile.presentation.api.ProfileApiImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun provideProfileApi(): ProfileApi {
        return ProfileApiImpl()
    }
}