package com.vladimirkondenko.beerbuddies.presentation.search

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import com.vladimirkondenko.beerbuddies.R
import kotlinx.android.synthetic.main.activity_seatch.*

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seatch)
        RxView.clicks(search_imagebutton_close).subscribe { finish() }
        RxTextView.textChanges(search_edittext_input)
                .filter { text -> text.length >= 3}
                .map { it.toString() }
                .subscribe { Log.i("Search", it) }
    }


}
