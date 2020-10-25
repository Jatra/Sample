package uk.co.jatra.sample.network

import com.google.gson.annotations.SerializedName
import uk.co.jatra.sample.model.Breed

data class BreedResponse(
    @SerializedName("status") val status: String,
    @SerializedName("message") val breeds: Map<String, List<String>>
) {
    fun toBreedList(): List<Breed> {
        return if (status == "success") {
            breeds.keys.map {
                Breed(it, breeds[it])
            }.toList()
        } else {
            emptyList()
        }
    }
}

