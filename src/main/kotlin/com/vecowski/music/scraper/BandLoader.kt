package com.vecowski.music.scraper

import org.springframework.stereotype.Service
import java.io.File

@Service
class BandLoader {

    fun loadBands(): List<String> {
        val bands = arrayListOf<String>()
        File(this::class.java.classLoader.getResource("bands_medium.txt").file).forEachLine {
            bands.add(it)
        }
        return bands
    }

}