package com.vecowski.music

import com.vecowski.music.scraper.BandLink
import com.vecowski.music.scraper.LastFMScraper
import com.vecowski.music.scraper.MusciansAndBands
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication(scanBasePackages = arrayOf("com.vecowski.music"))
class LyricsApplication: SpringBootServletInitializer() {

    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(LyricsApplication::class.java)
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(LyricsApplication::class.java, *args)
    val musciansAndBands = MusciansAndBands()
    val lastFMScraper = LastFMScraper(musciansAndBands)
    val bands = ArrayList<BandLink>()
    bands.add(BandLink("The Mars Volta", "https://www.last.fm/music/The+Mars+Volta/+wiki"))
    bands.add(BandLink("Antemasque", "https://www.last.fm/music/Antemasque/+wiki"))
    lastFMScraper.run(bands)

    println(musciansAndBands.size())
}