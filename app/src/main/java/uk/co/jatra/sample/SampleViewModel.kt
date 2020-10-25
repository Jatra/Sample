package uk.co.jatra.sample

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uk.co.jatra.sample.model.Breed

class SampleViewModel @ViewModelInject constructor(private val repository: Repository): ViewModel() {

    private val _liveData = MutableLiveData<List<Breed>>()
    val liveData: LiveData<List<Breed>> = _liveData

    init {
        viewModelScope.launch {
            val breedsData = repository.getBreeds()
            if (breedsData is DogData.Success) {
                _liveData.postValue(breedsData.breeds)
            }
        }
    }
}
