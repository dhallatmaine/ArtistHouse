package com.vecowski.music.scraper

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.ConcurrentHashMap

@RestController
class GreetingController(private val musiciansAndBands: MusiciansAndBands) {

    @GetMapping("/artists", produces = arrayOf("application/json"))
    fun greeting(): ConcurrentHashMap<String, HashSet<String>> {
        return musiciansAndBands.get()
    }

}