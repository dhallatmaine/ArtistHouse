package com.vecowski.music.scraper

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.ConcurrentHashMap

@RestController
class GreetingController(private val musciansAndBands: MusciansAndBands) {

    @GetMapping("/artists", produces = arrayOf("application/json"))
    fun greeting(): ConcurrentHashMap<String, HashSet<String>> {
        return musciansAndBands.get()
    }

}