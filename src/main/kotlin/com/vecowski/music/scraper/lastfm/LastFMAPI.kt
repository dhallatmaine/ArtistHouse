package com.vecowski.music.scraper.lastfm

import de.umass.lastfm.Artist
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class LastFMAPI(@Value("\${lastfm.api.key}") private val key: String) {

    fun search(term: String): Artist? {
        try {
            val artists = Artist.search(term, key)
            return if (artists == null || artists.isEmpty()) null else artists.first()
        } catch (e: Exception) { }
        return null
    }

}