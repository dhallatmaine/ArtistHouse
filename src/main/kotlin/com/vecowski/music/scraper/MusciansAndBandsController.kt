package com.vecowski.music.scraper

import com.vecowski.music.scraper.lastfm.LastFMAPI
import de.umass.lastfm.Artist
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.io.File

@RestController
class GreetingController(private val musciansAndBands: MusciansAndBands, private val lastFMAPI: LastFMAPI) {

    @GetMapping("/artists", produces = arrayOf("application/json"))
    fun greeting(): String {
        return File(this::class.java.classLoader.getResource("data.json").file).readText()
        //return musciansAndBands.get()
    }

}