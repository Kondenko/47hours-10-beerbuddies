package com.vladimirkondenko.beerbuddies.presentation.beer

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vladimirkondenko.beerbuddies.R
import com.vladimirkondenko.beerbuddies.data.beer.model.Beer
import com.vladimirkondenko.beerbuddies.presentation.beerdetails.BeerDetailsFragment
import kotlinx.android.synthetic.main.fragment_beer.*

class BeerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?)
            = inflater!!.inflate(R.layout.fragment_beer, container, false)!!

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = BeerAdapter(context)
        for (i in 0..15) adapter.addItem(Beer("Beer №$i", i * 10, i / 2f))
        beer_recyclerview_list.adapter = adapter
        adapter.clicks().subscribe {
            BeerDetailsFragment().show(this.fragmentManager, it.toString())
        }
        beer_rxfilter_simple.filterActions().subscribe { filterModel -> Log.i("Filter", filterModel.toString()) }
    }

}
