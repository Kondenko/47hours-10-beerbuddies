package com.vladimirkondenko.beerbuddies.presentation.beer

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vladimirkondenko.beerbuddies.R
import com.vladimirkondenko.beerbuddies.data.FirebaseManager
import com.vladimirkondenko.beerbuddies.presentation.beerdetails.BeerDetailsFragment
import kotlinx.android.synthetic.main.fragment_beer.*

class BeerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?)
            = inflater!!.inflate(R.layout.fragment_beer, container, false)!!

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = BeerAdapter(context)
        beer_recyclerview_list.adapter = adapter
        adapter.clicks().subscribe { beer ->
            BeerDetailsFragment.newInstance(beer.bar).show(this.fragmentManager, beer.toString())
        }
        FirebaseManager.pushBeer()
        FirebaseManager.pushPubs()
        val beerObsrevable = FirebaseManager.getBeer()
        beerObsrevable.subscribe { beer -> adapter.addItem(beer) }
        beer_rxfilter_simple.filterActions()
                .flatMap { fitler ->
                    beerObsrevable.replay()
                            .filter { beer ->
                                val compositeCondition = false
                                if (fitler.isAle) compositeCondition || beer.style.contains("ale")
                                if (fitler.isStout) compositeCondition || beer.style.contains("stout")
                                if (fitler.isPale) compositeCondition || beer.type.contains("pale")
                                compositeCondition
                            }
                }
                .doOnSubscribe { adapter.clear() }
                .subscribe { item ->
                    adapter.addItem(item)
                }
    }

}
