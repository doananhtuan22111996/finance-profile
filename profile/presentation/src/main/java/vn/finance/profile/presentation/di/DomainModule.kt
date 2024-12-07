package vn.finance.profile.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import vn.finance.profile.business.domain.repository.GetProfileRepository
import vn.finance.profile.business.domain.usecase.GetProfileUseCase

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetProfileUseCase(getProfileRepository: GetProfileRepository): GetProfileUseCase =
        GetProfileUseCase(repository = getProfileRepository)
}