package edu.temple.inclassactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val imageIds = MutableLiveData<IntArray>()

    fun setImageIds (imageIds: IntArray){
        this.imageIds.value = imageIds
    }

    fun getImageIds():LiveData<IntArray>{
        return imageIds
    }
}