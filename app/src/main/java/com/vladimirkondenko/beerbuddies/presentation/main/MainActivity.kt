package com.vladimirkondenko.beerbuddies.presentation.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import com.vladimirkondenko.beerbuddies.R
import com.vladimirkondenko.beerbuddies.presentation.beer.BeerFragment
import com.vladimirkondenko.beerbuddies.presentation.pubs.PubsFragment
import com.vladimirkondenko.beerbuddies.presentation.search.SearchActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(main_toolbar)
        main_viewpager.adapter = FragmentPagerItemAdapter(
                supportFragmentManager, FragmentPagerItems.with(this@MainActivity)
                .add(R.string.main_tab_beer, BeerFragment::class.java)
                .add(R.string.main_tab_pubs, PubsFragment::class.java)
                .create())
        main_smarttablayout.setViewPager(main_viewpager)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.main_action_search -> {
                val intent = Intent(this, SearchActivity::class.java)
                startActivity(intent)
            }
            else -> throw NullPointerException("No callback for menu item with id ${item.itemId}")
        }
        return super.onOptionsItemSelected(item)
    }

}
