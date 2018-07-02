package com.vecowski.music.scraper

import org.springframework.stereotype.Service
import java.io.File

@Service
class BandLoader {

    fun loadBands(): List<String> {
        val bands = arrayListOf<String>()
        this.javaClass::class.java.getResource("bands.txt").readText()
        File(this::class.java.classLoader.getResource("bands.txt").file).forEachLine {
            bands.add(it)
        }
        return bands
    }

}