package com.vladimirkondenko.beerbuddies.presentation.beerdetails

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vladimirkondenko.beerbuddies.R
import com.vladimirkondenko.beerbuddies.data.FirebaseManager
import com.vladimirkondenko.beerbuddies.presentation.BaseDialogFragment
import com.vladimirkondenko.beerbuddies.presentation.pubs.PubsAdapter
import kotlinx.android.synthetic.main.fragment_pubs.*

class BeerDetailsFragment : BaseDialogFragment() {

    companion object {
        val ARG_BAR_ID = "BAR_ID"
        fun newInstance(barId: Long): BeerDetailsFragment {
            val fragment = BeerDetailsFragment()
            val bundle = Bundle().apply { putLong(ARG_BAR_ID, barId); fragment.arguments = this }
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_pubs, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val barId = arguments.getLong(ARG_BAR_ID)
        val adapter = PubsAdapter(context)
        pubs_recyclerview_list.adapter = adapter
        FirebaseManager.getBars()
                .doOnEach { Log.i("Det", it.toString())}
                .filter { bar -> bar.id == barId }
                .doOnEach { Log.e("Det", it.toString())}
                .subscribe(adapter::addItem)
    }

}