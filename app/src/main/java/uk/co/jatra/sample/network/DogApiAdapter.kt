package uk.co.jatra.sample.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DogApiAdapter {
    private val interceptor: HttpLoggingInterceptor by lazy {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    private val client: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    val service: DogApi =
        Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/")
            .client(client)
            .addCallAdapterFactory(ResultAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(DogApi::class.java)
}
