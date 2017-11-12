package com.vladimirkondenko.beerbuddies.presentation.pubs


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vladimirkondenko.beerbuddies.R
import com.vladimirkondenko.beerbuddies.data.pubs.model.Pub
import com.vladimirkondenko.beerbuddies.presentation.pubdetails.PubDetailsFragment
import kotlinx.android.synthetic.main.fragment_pubs.*


class PubsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_pubs, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = PubsAdapter(context)
        for (i in 0..15)  adapter.addItem(Pub("Pub $i", "${i*10}th Avenut, ${i*100}"))
        pubs_recyclerview_list.adapter = adapter
        adapter.clicks().subscribe {
            PubDetailsFragment().show(this.fragmentManager, it.toString())
        }
    }

}
