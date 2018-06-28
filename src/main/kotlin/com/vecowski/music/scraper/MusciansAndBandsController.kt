package com.vecowski.music.scraper

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController {

    @Autowired
    val musciansAndBands: MusciansAndBands? = null

    @GetMapping("/artists", produces = arrayOf("application/json"))
    fun greeting(): HashMap<String, HashSet<String>> {

        return musciansAndBands!!.get()
    }

}