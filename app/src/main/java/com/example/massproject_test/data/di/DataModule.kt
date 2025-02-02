package com.example.massproject_test.data.di

import android.app.Application
import androidx.room.Room
import com.example.massproject_test.data.local.MassDatabase
import com.example.massproject_test.data.local.dao.MassDao
import com.example.massproject_test.data.network.MassApi
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

private const val BASE_URL = "https://rickandmortyapi.com/api/"

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .callTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    @Named("retrofit")
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideMassApi(retrofit: Retrofit): MassApi {
        return retrofit.create(MassApi::class.java)
    }

    @Singleton
    @Provides
    fun provideDatabase(app: Application): MassDatabase {
        return Room.databaseBuilder(app, MassDatabase::class.java, "mass_db").build()
    }

    @Singleton
    @Provides
    fun provideMassDao(db: MassDatabase): MassDao = db.dao
}