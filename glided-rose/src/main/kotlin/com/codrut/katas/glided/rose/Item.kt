package com.codrut.katas.glided.rose

data class Item(
    var name: String,
    var sellIn: Int,
    var quality: Int
) {

    fun decreaseQuality() {
        if(quality > 0) {
            quality = quality.dec()
        }
    }

    fun increaseQuality() {
        if(quality < 50) {
            quality = quality.inc()
        }
    }

    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }
}