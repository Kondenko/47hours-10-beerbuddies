package com.vladimirkondenko.beerbuddies.data.beer.model

data class Beer(
        val bar: Long = -1,
        val brand: String = String(),
        val desc: String = String(),
        val price: String = String(),
        val rating: Int = 0,
        val style: String = String(),
        val type: String = String(),
        val degree: String = String()
)