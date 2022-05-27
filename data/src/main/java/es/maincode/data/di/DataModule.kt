package es.maincode.data.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import es.maincode.data.detail.DetailRemoteDataSource
import es.maincode.data.detail.DetailRepositoryImpl
import es.maincode.data.detail.DetailService
import es.maincode.data.list.ListRemoteDataSource
import es.maincode.data.list.ListRepositoryImpl
import es.maincode.data.list.ListService
import es.maincode.domain.detail.DetailRepository
import es.maincode.domain.list.ListRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val logginInterceptor = HttpLoggingInterceptor()
        logginInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com:443/v1/public/")
            .client(OkHttpClient.Builder()
                .connectTimeout(60L, TimeUnit.SECONDS)
                .addInterceptor(logginInterceptor)
                .build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideListDataSource(service: ListService): ListRemoteDataSource =
        ListRemoteDataSource(service)

    @Provides
    @Singleton
    fun provideListRepository(dataSource: ListRemoteDataSource): ListRepository =
        ListRepositoryImpl(dataSource)

    @Provides
    @Singleton
    fun provideDetailRepository(dataSource: DetailRemoteDataSource): DetailRepository =
        DetailRepositoryImpl(dataSource)

    @Provides
    @Singleton
    fun provideListService(retrofit: Retrofit): ListService =
        retrofit.create(ListService::class.java)

    @Provides
    @Singleton
    fun provideDetailService(retrofit: Retrofit): DetailService =
        retrofit.create(DetailService::class.java)
}