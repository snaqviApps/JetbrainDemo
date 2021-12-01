package org.com.testing.with.jetbrainsdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

open class MainViewModel : ViewModel() {

    private val TAG = MainViewModel::class.java.simpleName

    private var _data = MutableLiveData<List<Article>>()
    val data: LiveData<List<Article>>
        get() = _data

    fun fetchData(): Job = viewModelScope.launch(Dispatchers.IO) {
        val lstRes = mutableListOf(
            Article(
                title = "Name 1",
                content = "The PNG format is widely supported and works best with presentations and web design. ",
                imageURL = "https://cdn4.iconfinder.com/data/icons/bettericons/354/github-512.png"
            ),
            Article(
                title = "Name 2",
                content = "The PNG format is widely supported and works best with presentations and web design. ",
                imageURL = "https://cdn4.iconfinder.com/data/icons/bettericons/354/github-512.png"
            ),
            Article(
                title = "Name 3",
                content = "The PNG format is widely supported and works best with presentations and web design. ",
                imageURL = "https://cdn4.iconfinder.com/data/icons/bettericons/354/github-512.png"
            ),
            Article(
                title = "Name 4",
                content = "The PNG format is widely supported and works best with presentations and web design. ",
                imageURL = "https://cdn4.iconfinder.com/data/icons/bettericons/354/github-512.png"
            ),
            Article(
                title = "Name 5",
                content = "The PNG format is widely supported and works best with presentations and web design. ",
                imageURL = "https://cdn4.iconfinder.com/data/icons/bettericons/354/github-512.png"
            )
        )
        _data.postValue(lstRes)
    }

}