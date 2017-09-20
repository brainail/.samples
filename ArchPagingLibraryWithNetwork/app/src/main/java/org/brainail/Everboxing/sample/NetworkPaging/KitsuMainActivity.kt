package org.brainail.Everboxing.sample.NetworkPaging

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*
import org.brainail.Everboxing.sample.NetworkPaging.R


class KitsuMainActivity: AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProviders.of(this).get(KitsuViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initSearchField()
        searchForResults("Android")
    }

    private fun initKitsu() {
        val kitsuAdapter = KitsuPagedListAdapter()
        searchResultsRecyclerView.adapter = kitsuAdapter
        viewModel.allKitsu.observe(this, Observer(kitsuAdapter::setList))
    }

    private fun searchForResults(queryFilter: String) {
        viewModel.setQueryFilter(queryFilter)
        initKitsu()
    }

    private fun hideIme() {
        val InputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        InputMethodManager.hideSoftInputFromWindow(searchInputView.windowToken, 0)
    }

    private fun initSearchField() {
        searchStartView.setOnClickListener {
            hideIme()
            searchForResults(searchInputView.text.toString())
        }
        appBarView.addOnOffsetChangedListener { _, verticalOffset ->
            searchContainerView.translationY = verticalOffset.toFloat()
        }
    }
}
