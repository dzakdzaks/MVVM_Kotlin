package com.dzakdzaks.mvvmkotlina.view

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.dzakdzaks.mvvmkotlina.R
import com.dzakdzaks.mvvmkotlina.di.Injection
import com.dzakdzaks.mvvmkotlina.model.Museum
import com.dzakdzaks.mvvmkotlina.viewmodel.MuseumViewModel
import com.dzakdzaks.mvvmkotlina.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_error.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MuseumViewModel
    private lateinit var adapter: MuseumAdapter

    companion object {
        const val TAG = "CONSOLE"
    }


    /**
    //Consider this, if you need to call the service once when activity was created.
    Log.v(TAG,"savedInstanceState $savedInstanceState")
    if(savedInstanceState==null){
    viewModel.loadMuseums()
    }
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
        setupUI()

    }

    private fun setupUI() {
        adapter = MuseumAdapter(viewModel.museums.value ?: emptyList())

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
            recyclerView.layoutManager = LinearLayoutManager(this)
        else
            recyclerView.layoutManager = GridLayoutManager(this, 4)

        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = adapter
    }


    //viewmodel
    /**
    //Consider this if ViewModel class don't require parameters.
    viewModel = ViewModelProviders.of(this).get(MuseumViewModel::class.java)

    //if you require any parameters to  the ViewModel consider use a ViewModel Factory
    viewModel = ViewModelProviders.of(this,ViewModelFactory(Injection.providerRepository())).get(MuseumViewModel::class.java)

    //Anonymous observer implementation
    viewModel.museums.observe(this,Observer<List<Museum>> {
    Log.v("CONSOLE", "data updated $it")
    adapter.update(it)
    })
     */

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(this, ViewModelFactory(Injection.providerMuseumRepo()))
            .get(MuseumViewModel::class.java)
        viewModel.museums.observe(this, renderMuseums)

        viewModel.isViewLoading.observe(this, isViewLoadingObserver)
        viewModel.onMessageError.observe(this, onMessageErrorObserver)
        viewModel.isEmptyList.observe(this, isEmptyListObserver)

    }

    private val renderMuseums = Observer<List<Museum>> {
        Log.v(TAG, "data updated $it")
        layoutError.visibility = View.GONE
        layoutEmpty.visibility = View.GONE
        adapter.update(it)
    }

    private val isViewLoadingObserver = Observer<Boolean> {
        Log.v(TAG, "isViewLoading $it")
        val visibility = if (it) View.VISIBLE else View.GONE
        layoutEmpty.visibility = View.GONE
        layoutError.visibility = View.GONE
        progressBar.visibility = visibility
    }

    private val onMessageErrorObserver = Observer<Any> {
        Log.v(TAG, "onMessageError $it")
        layoutError.visibility = View.VISIBLE
        layoutEmpty.visibility = View.GONE
        textViewError.text = "Error $it"
    }

    private val isEmptyListObserver = Observer<Boolean> {
        Log.v(TAG, "emptyListObserver $it")
        layoutError.visibility = View.GONE
        layoutEmpty.visibility = View.VISIBLE
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadMuseum()
    }

}
