package uk.co.jatra.sample

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class Repository @Inject constructor(@ApplicationContext val context: Context) {
    fun getBreeds(): List<String> {
        return listOf("Dalmatian", "Golden Retriever")
    }
}