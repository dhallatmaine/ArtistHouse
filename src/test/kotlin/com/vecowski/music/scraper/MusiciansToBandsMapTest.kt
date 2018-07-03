package com.vecowski.music.scraper

import org.junit.Before
import org.junit.Test

class MusiciansToBandsMapTest {

    private val musciansAndBands = MusiciansToBandsMap()

    @Before
    fun setup() {
        musciansAndBands.clear()
    }

    @Test
    fun add() {
        musciansAndBands.add("name", "band")
        musciansAndBands.add("name", "band1")
    }

}