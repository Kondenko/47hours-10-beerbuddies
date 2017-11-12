package com.vladimirkondenko.beerbuddies.data

import com.androidhuman.rxfirebase2.database.ChildEvent
import com.androidhuman.rxfirebase2.database.childEvents
import com.google.firebase.database.FirebaseDatabase
import com.vladimirkondenko.beerbuddies.data.beer.model.Beer
import com.vladimirkondenko.beerbuddies.data.pubs.model.Pub
import io.reactivex.Observable

object FirebaseManager {

    private val beerRef = FirebaseDatabase.getInstance().reference.child("sort")
    private val pubsRef = FirebaseDatabase.getInstance().reference.child("bar")

    fun pushPubs() {
        val key = pubsRef.push().key
        pubsRef.child(key).child("name").setValue("MacLaren\\'s Pub")
        pubsRef.child(key).child("address").setValue("Ростов-на-Дону Университетский 61")
    }

    fun getPubs(): Observable<Pub>
            = pubsRef.childEvents()
            .map { data -> Pub(name = data.getString("name"), desc = data.getString("address")) }

    fun getBeer(): Observable<Beer>
            = beerRef.childEvents()
            .map { data -> Beer(brand = data.getString("brand"), desc = data.getString("desc"), price = "$" + data.getString("price")) }

    private fun ChildEvent.getString(key: String) = this.dataSnapshot().child(key).value.toString()

}