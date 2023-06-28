package com.gajanan.pojoapp.domain.di

import android.app.Application
import androidx.room.Room
import com.gajanan.pojoapp.domain.localDatabase.PostDatabase
import com.gajanan.pojoapp.domain.network.EndPoints.BASE_URL
import com.gajanan.pojoapp.domain.network.MyApi
import com.gajanan.pojoapp.utils.Constants.CONNECTION_TIMEOUT
import com.gajanan.pojoapp.utils.Constants.READ_TIMEOUT
import com.gajanan.pojoapp.utils.Constants.WRITE_TIMEOUT
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MyModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit{
        val gson = GsonBuilder().serializeNulls().create()
        val client: OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(
                CONNECTION_TIMEOUT.toLong(),
                TimeUnit.SECONDS
            )
            .readTimeout(
                READ_TIMEOUT.toLong(),
                TimeUnit.SECONDS
            )
            .writeTimeout(WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Singleton
    @Provides
    fun provideApi(retrofit : Retrofit) :MyApi =
        retrofit.create(MyApi::class.java)

    @Provides
    @Singleton
    fun providePostDatabase(app: Application): PostDatabase =
        Room.databaseBuilder(app , PostDatabase::class.java,"post_db")
            .build()
}