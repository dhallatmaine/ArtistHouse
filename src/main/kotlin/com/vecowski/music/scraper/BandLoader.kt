package com.vecowski.music.scraper

import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service

@Service
class BandLoader {

    fun loadBands(): List<String> {
        val bands = arrayListOf<String>()
        ClassPathResource("bands_medium.txt").inputStream.bufferedReader().forEachLine {
            bands.add(it)
        }
        return bands
    }

}