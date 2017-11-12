package com.vladimirkondenko.beerbuddies.data.beer.model

import com.vladimirkondenko.beerbuddies.data.pubs.model.Pub

data class Beer(
        val pub: Pub = Pub(),
        val brand: String = String(),
        val desc: String = String(),
        val price: String = String(),
        val rating: Int = 0,
        val style: String = String(),
        val type: String = String(),
        val degree: String = String()
)