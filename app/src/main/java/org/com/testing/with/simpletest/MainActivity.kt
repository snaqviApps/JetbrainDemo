package org.com.testing.with.simpletest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
//import androidx.lifecycle.lifecycleScope
import org.com.testing.with.simpletest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var _artBinding: ActivityMainBinding     // ViewBinding implementation
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)              // conventional approach, withOut dataBinding / ViewBinding

        _artBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_artBinding.root)                        // ViewBinding implementation

        _artBinding.lifecycleOwner = this

        // provide viewModel
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        _artBinding.mainViewModelXML = mainViewModel

        val adapter = ArticleAdapter()
        _artBinding.articleRecyclerList.adapter = adapter

//        adapter.articleList = listOf(listOf(mainViewModel.fetchData()).toString())

        mainViewModel.data.observe(this, Observer {
            it?.let {
                adapter.articleList = it
            }
        })

//        adapter.articleList[0].content = "Hi-no-observer"

    }
    
}