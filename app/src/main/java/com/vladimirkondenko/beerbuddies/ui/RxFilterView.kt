package com.vladimirkondenko.beerbuddies.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.jakewharton.rxbinding2.widget.RxCompoundButton
import com.vladimirkondenko.beerbuddies.R
import io.reactivex.Observable
import io.reactivex.functions.Function3
import kotlinx.android.synthetic.main.item_beer_filter_simple.view.*

class RxFilterView(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {

    constructor(context: Context) : this(context, null)

    private val inflater = LayoutInflater.from(context)

    init {
        val view = inflater.inflate(R.layout.item_beer_filter_simple, null)
        this.addView(view)
    }

    fun filterActions(): Observable<FilterModel> {
        val paleChanges: Observable<Boolean> = RxCompoundButton.checkedChanges(all_beerfilter_checkbox_pale)
        val brownChanges: Observable<Boolean> = RxCompoundButton.checkedChanges(all_beerfilter_checkbox_brown)
        val unfilteredChanges: Observable<Boolean> = RxCompoundButton.checkedChanges(all_beerfilter_checkbox_unfiltered)
        return Observable.combineLatest(paleChanges, brownChanges, unfilteredChanges,
                Function3<Boolean, Boolean, Boolean, FilterModel>  { isPale, isBrown, isUnfiltered ->
                    FilterModel(isPale, isBrown, isUnfiltered)
                }
        )
    }

    data class FilterModel(val isPale: Boolean = false, val isBrown: Boolean = false, val isUnfiltered: Boolean = false)

}