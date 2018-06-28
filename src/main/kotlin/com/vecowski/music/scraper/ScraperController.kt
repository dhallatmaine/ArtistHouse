package com.vecowski.music.scraper

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ScraperController {

    @Autowired
    val lastFMScraper: LastFMScraper? = null

    @GetMapping("/scrape", produces = arrayOf("application/json"))
    fun run() {
        val bands = ArrayList<BandLink>()
        bands.add(BandLink("The Mars Volta", "https://www.last.fm/music/The+Mars+Volta/+wiki"))
        bands.add(BandLink("Antemasque", "https://www.last.fm/music/Antemasque/+wiki"))
        bands.add(BandLink("Bosnian Rainbows", "https://www.last.fm/music/Bosnian+Rainbows/+wiki"))
        bands.add(BandLink("At the Drive-In", "https://www.last.fm/music/At+the+Drive-In/+wiki"))
        lastFMScraper!!.run(bands)
    }

}