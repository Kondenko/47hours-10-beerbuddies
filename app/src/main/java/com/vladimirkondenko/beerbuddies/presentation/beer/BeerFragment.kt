package com.vladimirkondenko.beerbuddies.presentation.beer

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import com.vladimirkondenko.beerbuddies.R

class BeerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                                     savedInstanceState: Bundle?)
            = inflater!!.inflate(R.layout.beer_list, container, false)

}
