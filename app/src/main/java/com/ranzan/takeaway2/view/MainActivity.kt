package com.ranzan.takeaway2.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.arlib.floatingsearchview.FloatingSearchView.OnQueryChangeListener
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion
import com.ranzan.takeaway2.R
import com.ranzan.takeaway2.databinding.ActivityMainBinding
import com.ranzan.takeaway2.model.api.AddressListItem
import com.ranzan.takeaway2.model.api.ResponseModel
import com.ranzan.takeaway2.viewmodel.TheViewModel
import com.ranzan.takeaway2.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var list: ArrayList<AddressListItem>
    private lateinit var viewModel: TheViewModel
    private lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this, ViewModelFactory()).get(TheViewModel::class.java)
//        searchData("")
//        activityMainBinding.searchView.setOnQueryTextListener(object :
//            SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(p0: String?): Boolean {
//                searchData(p0!!)
//                return false
//            }
//            override fun onQueryTextChange(p0: String?): Boolean {
//                searchData(p0!!)
//                return false
//            }
//
//        })
        activityMainBinding.searchView.setOnQueryChangeListener(OnQueryChangeListener { oldQuery, newQuery -> //get suggestions based on newQuery
            viewModel.getDataFromApi(newQuery).observe(this@MainActivity, Observer {
                activityMainBinding.searchView.swapSuggestions(getSuggestions(it))
            })
        })
    }

    private fun getSuggestions(it: ResponseModel?): MutableList<out SearchSuggestion>? {
        val suggestionsList = ArrayList<Suggestions>()
        val list = it?.data?.addressList

        list?.forEach {
            val suggestion = Suggestions(it!!.addressString!!)
            suggestionsList.add(suggestion)
        }
        return suggestionsList
    }

//    private fun setRecyclerView(list: ArrayList<AddressListItem>) {
//        val recyclerViewAdapter = RecyclerView(list)
//        activityMainBinding.recyclerView.apply {
//            adapter = recyclerViewAdapter
//            layoutManager = LinearLayoutManager(this@MainActivity)
//        }
//    }
//
//    private fun searchData(text: String) {
//        viewModel.getDataFromApi(text).observe(this@MainActivity, Observer {
//            list = it.data!!.addressList as ArrayList<AddressListItem>
//            setRecyclerView(list)
//        })
//    }
}