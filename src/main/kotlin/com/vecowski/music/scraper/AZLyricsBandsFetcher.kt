package com.vecowski.music.scraper

import org.jsoup.Jsoup
import org.springframework.stereotype.Component

@Component
class AZLyricsBandsFetcher {

    val pages = arrayListOf<String>("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u",
        "v","w","x","y","z","19")

    fun run() {
        for (page in pages) {
            val doc = Jsoup.connect("https://www.azlyrics.com/$page.html").get()
            val bands = doc.select("body > div.container.main-page > div > div > a")
            for (band in bands) {
                println(band.childNode(0).toString())
            }
        }
    }

}