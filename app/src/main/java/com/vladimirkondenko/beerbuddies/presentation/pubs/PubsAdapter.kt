package com.vladimirkondenko.beerbuddies.presentation.pubs

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.vladimirkondenko.beerbuddies.R
import com.vladimirkondenko.beerbuddies.data.pubs.model.Pub
import com.vladimirkondenko.beerbuddies.presentation.BaseRxAdapter

class PubsAdapter(context: Context) : BaseRxAdapter<Pub, PubsAdapter.ViewHolder>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(getView(R.layout.item_pub, parent))

    class ViewHolder(view: View) : BaseViewHolder<Pub>(view) {

        override fun bindItem(item: Pub) {
            super.bindItem(item)
            itemView.findViewById<TextView>(R.id.item_pub_name).text = item.name
            itemView.findViewById<TextView>(R.id.item_pub_address).text = item.address
        }

    }

}