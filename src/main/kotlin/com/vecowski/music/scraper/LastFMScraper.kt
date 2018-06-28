package com.vecowski.music.scraper

import org.jsoup.Jsoup
import org.jsoup.select.Elements
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class LastFMScraper : Scraper {

    @Autowired
    val musciansAndBands: MusciansAndBands? = null

    override fun run(bands: List<BandLink>) {
        for (band in bands) {
            scrape(band.name, band.link)
        }
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
            musciansAndBands!!.add(name, band)
        }
    }

}