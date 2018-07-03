package com.vecowski.music.scraper

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController(private val musiciansToBandsMap: MusiciansToBandsMap, private val searchService: SearchService) {

    @GetMapping("/artists", produces = arrayOf("application/json"))
    fun artists(): HashMap<String, HashSet<String>> {
        return musiciansToBandsMap.get()
    }

    @GetMapping("/search", produces = arrayOf("application/json"))
    fun search(@RequestParam(value = "term", defaultValue = "all") term: String): HashMap<String, HashSet<String>> {
        if (! term.equals("all")) {
            return searchService.search(term.toLowerCase())
        }
        return musiciansToBandsMap.get()
    }

}