package vn.finance.profile.presentation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import vn.finance.profile.business.data.repository.GetProfileRepositoryImpl
import vn.finance.profile.business.domain.repository.GetProfileRepository

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindGetProfileRepository(getProfileRepositoryImpl: GetProfileRepositoryImpl): GetProfileRepository
}