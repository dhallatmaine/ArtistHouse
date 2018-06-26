package com.vecowski.music.scraper

import org.junit.Before
import org.junit.Test

class MusciansAndBandsTest {

    private val musciansAndBands = MusciansAndBands()

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