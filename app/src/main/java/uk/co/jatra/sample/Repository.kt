package uk.co.jatra.sample

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import uk.co.jatra.sample.model.Breed
import uk.co.jatra.sample.network.BreedResponse
import uk.co.jatra.sample.network.DogApi
import uk.co.jatra.sample.network.Result
import javax.inject.Inject

class Repository @Inject constructor(@ApplicationContext val context: Context, val dogApi: DogApi) {
    suspend fun getBreeds(): DogData {
        val response: Result<BreedResponse> = dogApi.getBreeds()
        if (response is Result.Success) {
            if (response.data?.status == "success") {
                val breedResponse: BreedResponse = response.data
                return DogData.Success(breedResponse.toBreedList())
            }
        }
        return DogData.Failure
    }
}

sealed class DogData {
    class Success(val breeds: List<Breed>) : DogData()
    object Failure : DogData()
}