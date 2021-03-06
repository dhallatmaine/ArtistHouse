package com.vecowski.music.scraper

import com.vecowski.music.scraper.lastfm.LastFMAPI
import com.vecowski.music.scraper.lastfm.LastFMScraper
import de.umass.lastfm.Artist
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ScraperController(
        private val lastFMScraper: LastFMScraper,
        private val bandLoader: BandLoader,
        private val lastFMAPI: LastFMAPI,
        private val musiciansToBandsMap: MusiciansToBandsMap) {

    /*
    @GetMapping("/scrape", produces = arrayOf("application/json"))
    fun run() {
        val bandList = bandLoader.loadBands()

        for (band in bandList) {
            val artist = lastFMAPI.search(band)
            if (artist != null) {
                lastFMScraper.run(artist)
            }
        }

        // only display artists in more than 1 band
        val mutableIterator = musiciansToBandsMap.get().keys.iterator()
        for (key in mutableIterator) {
            if (musiciansToBandsMap.get().get(key)!!.size == 1) musiciansToBandsMap.get().remove(key)
        }
    }
    */

}