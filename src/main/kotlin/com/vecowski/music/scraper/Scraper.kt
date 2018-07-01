package com.vecowski.music.scraper

import de.umass.lastfm.Artist

interface Scraper {

    fun run(band: Artist)

}