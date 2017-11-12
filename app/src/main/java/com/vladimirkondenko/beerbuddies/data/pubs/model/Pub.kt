package com.vladimirkondenko.beerbuddies.data.pubs.model

data class Pub(
        val id: Int = 0,
        val name: String = String(),
        val lat: Int = 0,
        val lng: Int = 0,
        val address: String = String(),
        val rating: Int = 0,
        val desc: String? = String()
)