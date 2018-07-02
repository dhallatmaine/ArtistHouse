package com.vecowski.music.scraper.lastfm

import com.vecowski.music.scraper.MusiciansAndBands
import com.vecowski.music.scraper.Scraper
import de.umass.lastfm.Artist
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import org.springframework.stereotype.Component
import java.lang.Exception

@Component
class LastFMScraper(private val musiciansAndBands: MusiciansAndBands) : Scraper {

    override fun run(band: Artist) {
        try {
            scrape(band.name, band.url + "/+wiki")
        } catch (e: Exception) { }
    }

    fun scrape(band: String, link: String) {
        val doc = Jsoup.connect(link).get()
        val ulMembers = doc.select("#mantle_skin > div.container.page-content > div > div.col-main > ul > li > ul > li > a")
        addMembers(ulMembers, band)
        val moreulMembers = doc.select("#factbox-more-members > li > a")
        addMembers(moreulMembers, band)
    }

    fun addMembers(ulMembers: Elements, band: String) {
        for (member in ulMembers) {
            val name = member.childNode(0).toString()
            musiciansAndBands!!.add(name, band)
        }
    }

}