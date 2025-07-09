package com.rishu.quizapplication.di

import com.rishu.quizapplication.data.network.QuizApi
import com.rishu.quizapplication.data.repository.QuizRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import kotlin.jvm.java


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //Base URL can be defined in build.gradle file and can be changed based on flavours,
    // but for simplicity, I'm are defining it here.

    // Interceptor can also be added to add headers or logging.
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://gist.githubusercontent.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideQuizApi(retrofit: Retrofit): QuizApi =
        retrofit.create(QuizApi::class.java)

    @Provides
    @Singleton
    fun provideQuizRepository(api: QuizApi) = QuizRepository(api)
}
