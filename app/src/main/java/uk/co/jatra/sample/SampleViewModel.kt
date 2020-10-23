package uk.co.jatra.sample

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SampleViewModel @ViewModelInject constructor(private val repository: Repository): ViewModel() {

    val _liveData = MutableLiveData<List<String>>()
    val liveData: LiveData<List<String>> = _liveData

    init {
        _liveData.value = repository.getBreeds()
    }

}