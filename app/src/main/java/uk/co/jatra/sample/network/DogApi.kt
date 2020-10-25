package uk.co.jatra.sample.network

import retrofit2.http.GET
import retrofit2.http.Path

interface DogApi {
    @GET("breeds/list/all")
    suspend fun getBreeds(): Result<BreedResponse>

    @GET("breed/{breedName}/images/random")
    suspend fun getImageByUrl(@Path("breedName") breedName: String): Result<String>
}
