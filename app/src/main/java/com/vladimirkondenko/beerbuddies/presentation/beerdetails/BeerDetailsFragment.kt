package com.vladimirkondenko.beerbuddies.presentation.beerdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vladimirkondenko.beerbuddies.R
import com.vladimirkondenko.beerbuddies.data.pubs.model.Pub
import com.vladimirkondenko.beerbuddies.presentation.BaseDialogFragment
import com.vladimirkondenko.beerbuddies.presentation.pubs.PubsAdapter
import kotlinx.android.synthetic.main.fragment_pubs.*
import java.util.*

class BeerDetailsFragment : BaseDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_pubs, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = PubsAdapter(context)
        for (i in 0..15) if (Random().nextBoolean()) adapter.addItem(Pub("Pub $i", "${i * 10}th Avenue, ${i * 15}"))
        pubs_recyclerview_list.adapter = adapter
    }

}