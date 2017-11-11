package com.vladimirkondenko.beerbuddies.presentation


import android.content.Context
import android.support.annotation.CallSuper
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import java.util.*


/**
 * Created by Vladimir Kondenko on 09.08.17.
 */

abstract class BaseRxAdapter<I, VH : BaseRxAdapter.BaseViewHolder<I>>
@JvmOverloads constructor(context: Context, private var items: ArrayList<I> = ArrayList()) : RecyclerView.Adapter<VH>() {

    private val itemClickSubject = PublishSubject.create<I>()

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    init {
        notifyDataSetChanged()
    }

    abstract override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): VH

    @CallSuper
    override fun onBindViewHolder(vh: VH, i: Int) {
        val item = items[i]
        vh.bindItem(item)
        RxView.clicks(vh.itemView)
                .map({ _ -> item })
                .subscribe(itemClickSubject)
    }

    fun clicks(): Observable<I> = itemClickSubject

    fun setData(items: ArrayList<I>) {
        this.items = items
        notifyDataSetChanged()
    }

    fun addItem(city: I) {
        if (!items.contains(city)) {
            items.add(city)
            notifyDataSetChanged()
        }
    }

    fun getItem(i: Int): I {
        return items[i]
    }

    fun remove(i: Int) {
        items.removeAt(i)
        notifyDataSetChanged()
    }

    fun remove(item: I) {
        items.remove(item)
        notifyDataSetChanged()
    }

    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount() = items.size

    protected fun getView(@LayoutRes layout: Int, parent: ViewGroup) = inflater.inflate(layout, parent, false)

    abstract class BaseViewHolder<I>(view: View) : RecyclerView.ViewHolder(view) {

        var item: I? = null
            private set

        //        open var item: I? = null

        @CallSuper
        open fun bindItem(item: I) {
            this.item = item
        }

    }
}