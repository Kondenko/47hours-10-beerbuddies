package com.vladimirkondenko.beerbuddies.presentation.pubdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vladimirkondenko.beerbuddies.R
import com.vladimirkondenko.beerbuddies.data.beer.model.Beer
import com.vladimirkondenko.beerbuddies.presentation.BaseDialogFragment
import com.vladimirkondenko.beerbuddies.presentation.beer.BeerAdapter
import kotlinx.android.synthetic.main.fragment_beer.*
import java.util.*

class PubDetailsFragment : BaseDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?)
            = inflater!!.inflate(R.layout.fragment_beer, container, false)!!

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = BeerAdapter(context)
        for (i in 0..15) if (Random().nextBoolean()) adapter.addItem(Beer("Beer №$i", i * 10, i / 2f))
        beer_recyclerview_list.adapter = adapter
    }

}