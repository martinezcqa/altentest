package es.maincode.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.maincode.domain.detail.DetailRepository
import es.maincode.domain.detail.GetDetailUseCase
import es.maincode.domain.list.GetListUseCase
import es.maincode.domain.list.ListRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideGetListUseCase(repository: ListRepository): GetListUseCase =
        GetListUseCase(repository)

    @Provides
    @Singleton
    fun provideGetDetailUseCase(repository: DetailRepository): GetDetailUseCase =
        GetDetailUseCase(repository)
}