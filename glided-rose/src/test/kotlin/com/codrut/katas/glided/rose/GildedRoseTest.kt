package com.codrut.katas.glided.rose
import com.codrut.katas.glided.rose.SPECIAL_TYPES.AGED_BRIE
import com.codrut.katas.glided.rose.SPECIAL_TYPES.SULFURAS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun `quality and soldIn should not decrease for "Sulfuras"`() {
        val sulfurasList = listOf(Item(SULFURAS, 0, 80))
        val productManager = GildedRose(sulfurasList)

        productManager.updateQuality()

        assertEquals(80, sulfurasList[0].quality)
        assertEquals(0, sulfurasList[0].sellIn)
        assertEquals(SULFURAS, sulfurasList[0].name)
    }

    @Test
    fun `quality should increase as soldIn decreases for "Aged Brie"`() {
        val startQuality = 40
        val startSellIn = 10
        val sulfurasList = listOf(Item(AGED_BRIE, startSellIn, startQuality))
        val productManager = GildedRose(sulfurasList)

        for (i in 1..10) {
            productManager.updateQuality()

            assertEquals(startQuality + i, sulfurasList[0].quality)
            assertEquals(startSellIn - i, sulfurasList[0].sellIn)
            assertEquals(AGED_BRIE, sulfurasList[0].name)
        }
    }

}