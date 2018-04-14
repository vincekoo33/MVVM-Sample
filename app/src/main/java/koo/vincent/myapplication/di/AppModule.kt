package koo.vincent.myapplication.di

import dagger.Module
import dagger.Provides
import koo.vincent.myapplication.network.RetrofitService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [(ViewModelModule::class)])
internal class AppModule {
    @Singleton
    @Provides
    fun provideGithubService(): RetrofitService {
        return Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(RetrofitService::class.java)
    }

}