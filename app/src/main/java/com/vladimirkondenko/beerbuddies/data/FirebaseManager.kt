package com.vladimirkondenko.beerbuddies.data

import com.androidhuman.rxfirebase2.database.ChildEvent
import com.androidhuman.rxfirebase2.database.childEvents
import com.google.firebase.database.FirebaseDatabase
import com.vladimirkondenko.beerbuddies.data.beer.model.Beer
import com.vladimirkondenko.beerbuddies.data.pubs.model.Bar
import io.reactivex.Observable

object FirebaseManager {

    private val beerRef = FirebaseDatabase.getInstance().reference.child("sort")
    private val pubsRef = FirebaseDatabase.getInstance().reference.child("bar")

    fun pushPubs() {
        pushPub(0, "MacLaren\'s Pub", "Ростов-на-Дону, пер. Университетский, 61")
        pushPub(1, "BeerBuddies Bar", "Ростов-на-Дону, ул. Большая Садовая, 15")
        pushPub(2, "Guzzler", "Таганрог, ул. Петровская, 30")
        pushPub(3, "Heart's Pub", "Таганрог, ул. Фрунзе, 14")
        pushPub(4, "Doberman", "Таганрог, ул. Петровская, 62")
    }

    fun pushBeer() {
        pushBeer(bar = 0, name = "Keystone", desc = "A perfectly drinkable cheap beer", price = 1, style = "Porter")
        pushBeer(bar = 1, name = "Michelob Ultra", desc = "It's only really good when ice cold", price = 1)
        pushBeer(bar = 2, name = "Barcelona", price = 7, style = "Porter")
        pushBeer(bar = 3, name = "Natural Ice", desc = "Ideal or beer pong games", price = 1)
        pushBeer(bar = 4, name = "Ammer", price = 11, style = "Stout")
        pushBeer(bar = 0, name = "Poschner", price = 11, style = "Porter")
        pushBeer(bar = 1, name = "Beijing", price = 6, style = "Stout")
        pushBeer(bar = 2, name = "Harpoon IPA", price = 13, style = "Ale", type = "Pale")
        pushBeer(bar = 3, name = "Sierra Neveda Pale Ale", price = 16, style = "Ale", type = "Pale")
        pushBeer(bar = 4, name = "Sam Adams", price = 14, style = "Stout")
        pushBeer(bar = 0, name = "Shock Top", price = 12, style = "Stout")
        pushBeer(bar = 1, name = "Blue Moon", price = 18, style = "Stout")
        pushBeer(bar = 2, name = "Lagunitas IPA ", price = 15, style = "Ale", type = "Pale")
        pushBeer(bar = 3, name = "Coors & Coors Light", price = 22, style = "Stout")
    }

    private fun pushBeer(bar: Int, name: String, desc: String? = String(), price: Int, type: String = "pale", style: String = "stout", abv: Int = 0, rating: Int = 0) {
        val key = beerRef.push().key
        beerRef.child(key).child("bar").setValue(bar)
        beerRef.child(key).child("brand").setValue(name)
        beerRef.child(key).child("desc").setValue(desc)
        beerRef.child(key).child("price").setValue(price)
        beerRef.child(key).child("type").setValue(type)
        beerRef.child(key).child("style").setValue(style)
        beerRef.child(key).child("abv").setValue(abv)
        beerRef.child(key).child("rating").setValue(rating)
    }

    private fun pushPub(id: Int, name: String, address: String) {
        val key = pubsRef.push().key
        pubsRef.child(key).child("id").setValue(id)
        pubsRef.child(key).child("name").setValue(name)
        pubsRef.child(key).child("address").setValue(address)
    }

    fun getBars(): Observable<Bar>
            = pubsRef.childEvents()
            .map { data -> Bar(id = data.get("id") as Long, name = data.getString("name"), desc = data.getString("address")) }

    fun getBeer(): Observable<Beer>
            = beerRef.childEvents()
//            .map { it.dataSnapshot().getValue(Beer::class.java)!! }
            .map { data -> Beer(bar = (data.get("bar") as Long), brand = data.getString("brand"), desc = data.getString("desc"), price = "$" + data.getString("price")) }

    private fun ChildEvent.get(key: String) = this.dataSnapshot().child(key).value

    private fun ChildEvent.getString(key: String) = this.dataSnapshot().child(key).value.toString()

}