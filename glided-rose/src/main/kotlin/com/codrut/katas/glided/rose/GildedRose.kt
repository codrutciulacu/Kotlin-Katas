package com.codrut.katas.glided.rose

import com.codrut.katas.glided.rose.SPECIAL_TYPES.AGED_BRIE
import com.codrut.katas.glided.rose.SPECIAL_TYPES.BACKSTAGE_PASSES
import com.codrut.katas.glided.rose.SPECIAL_TYPES.SULFURAS

object SPECIAL_TYPES {
    const val AGED_BRIE = "Aged Brie"
    const val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"
    const val SULFURAS = "Sulfuras, Hand of Ragnaros"
}

class GildedRose(var items: List<Item>) {
    fun updateQuality() {
        items.forEach { item ->
            if (item.name != AGED_BRIE && item.name != BACKSTAGE_PASSES && item.name != SULFURAS) {
                item.decreaseQuality()
            } else if (item.quality < 50) {
                item.quality = item.quality.inc()

                if (item.name == BACKSTAGE_PASSES) {
                    if (item.sellIn < 11) {
                        item.increaseQuality()
                    }

                    if (item.sellIn < 6) {
                        item.increaseQuality()
                    }
                }
            }

            if (item.name != SULFURAS) {
                item.sellIn = item.sellIn.dec()
            }

            if (item.sellIn < 0) {
                if (item.name != AGED_BRIE) {
                    if (item.name != BACKSTAGE_PASSES) {
                        if (item.name != SULFURAS) {
                            item.decreaseQuality()
                        }
                    } else {
                        item.quality = 0
                    }
                } else {
                    item.increaseQuality()
                }
            }
        }
    }
}