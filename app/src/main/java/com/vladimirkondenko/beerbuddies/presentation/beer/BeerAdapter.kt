package com.vladimirkondenko.beerbuddies.presentation.beer

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vladimirkondenko.beerbuddies.R
import com.vladimirkondenko.beerbuddies.presentation.beer.dummy.DummyContent.DummyItem

class BeerAdapter(private val mValues: List<DummyItem>) : RecyclerView.Adapter<BeerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_beer, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount() = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView)
}
