package com.vladimirkondenko.beerbuddies.presentation.pubdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vladimirkondenko.beerbuddies.R
import com.vladimirkondenko.beerbuddies.presentation.BaseDialogFragment
import com.vladimirkondenko.beerbuddies.presentation.beer.BeerAdapter
import kotlinx.android.synthetic.main.fragment_beer.*

class PubDetailsFragment : BaseDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?)
            = inflater!!.inflate(R.layout.fragment_beer, container, false)!!

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = BeerAdapter(context)
        beer_recyclerview_list.adapter = adapter
    }

}