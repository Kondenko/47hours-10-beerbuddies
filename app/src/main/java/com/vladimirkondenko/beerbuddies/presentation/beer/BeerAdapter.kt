package com.vladimirkondenko.beerbuddies.presentation.beer

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.vladimirkondenko.beerbuddies.R
import com.vladimirkondenko.beerbuddies.data.beer.model.Beer
import com.vladimirkondenko.beerbuddies.presentation.BaseRxAdapter

class BeerAdapter(context: Context) : BaseRxAdapter<Beer, BeerAdapter.ViewHolder>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(getView(R.layout.item_beer, parent))

    class ViewHolder(view: View) : BaseRxAdapter.BaseViewHolder<Beer>(view) {
/*
         override var item: Beer?
             get() = super.item
             set(value) {
                 itemView.item_beer_name.text = value?.name
             }
*/

        override fun bindItem(item: Beer) {
            super.bindItem(item)
            itemView.findViewById<TextView>(R.id.item_beer_name).text = item.name
        }


    }

}
