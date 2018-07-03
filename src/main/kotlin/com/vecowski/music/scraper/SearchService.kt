package com.vecowski.music.scraper

import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class SearchService(private val musiciansToBandsMap: MusiciansToBandsMap, private val bandsToMusiciansMap: BandsToMusiciansMap) {

    fun search(term: String): HashMap<String, HashSet<String>> {
        if (musiciansToBandsMap.get()[term] != null && musiciansToBandsMap.get()[term]!!.isNotEmpty()) {
            return artist(term)
        } else if (bandsToMusiciansMap.get()[term] != null && bandsToMusiciansMap.get()[term]!!.isNotEmpty()) {
            return band(term)
        }
        return HashMap()
    }

    private fun artist(term: String): HashMap<String, HashSet<String>> {
        val found = HashMap<String, HashSet<String>>()
        val musiciansMap = musiciansToBandsMap.get()
        if (musiciansMap[term] == null || musiciansMap[term]!!.isEmpty()) return found

        found[term] = musiciansMap[term]!!.toHashSet()
        val bandsToSearch = ConcurrentHashMap<String, Boolean>()
        musiciansMap[term]!!.forEach {
            bandsToSearch[it] = false
        }

        val iterator = bandsToSearch.keys.iterator()
        for (band in iterator) {
            val artists = bandsToMusiciansMap.get()[band]!!
            for (artist in artists.iterator()) {
                val artistsBands = musiciansMap[artist]!!.toHashSet()
                found[artist] = artistsBands
                for (artistBand in artistsBands) {
                    bandsToSearch[artistBand] = false
                }
            }
        }

        return found
    }

    private fun band(term: String): HashMap<String, HashSet<String>> {
        val found = HashMap<String, HashSet<String>>()
        val bandMap = bandsToMusiciansMap.get()

        val initialSearchResults = bandMap[term]
        if (initialSearchResults == null || initialSearchResults!!.isEmpty()) return found

        val bandsToSearch = ConcurrentHashMap<String, Boolean>()
        initialSearchResults.forEach {
            found[it] = musiciansToBandsMap.get()[it]!!.toHashSet()
            musiciansToBandsMap.get()[it]!!.forEach {
                bandsToSearch[it] = false
            }
        }

        val iterator = bandsToSearch.keys.iterator()
        for (band in iterator) {
            val artists = bandsToMusiciansMap.get()[band]!!
            for (artist in artists.iterator()) {
                val artistsBands = musiciansToBandsMap.get()[artist]!!.toHashSet()
                found[artist] = artistsBands
                for (artistBand in artistsBands) {
                    bandsToSearch[artistBand] = false
                }
            }
        }

        return found
    }

}