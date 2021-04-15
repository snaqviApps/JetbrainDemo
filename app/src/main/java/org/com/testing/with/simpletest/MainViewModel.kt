package org.com.testing.with.simpletest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val TAG = MainViewModel::class.java.simpleName

    private var _data = MutableLiveData<List<Article>>()
    val data: LiveData<List<Article>>
        get() = _data

    fun fetchData() = viewModelScope.launch(Dispatchers.IO) {
        val lstRes = mutableListOf(
            Article(
                "Name 1",
                "The PNG format is widely supported and works best with presentations and web design. "
            ),
            Article(
                "Name 2",
                "The JPG format is widely supported and works best with presentations and web design. "
            ),
            Article(
                "Name 2",
                "The DWM format is widely supported and works best with presentations and web design. "
            ),
            Article(
                "Name",
                "The PNG format is widely supported and works best with presentations and web design. "
            ),
            Article(
                "Name 5",
                "The PNG format is widely supported and works best with presentations and web design. "
            )
        )
        _data.postValue(lstRes)
    }

}