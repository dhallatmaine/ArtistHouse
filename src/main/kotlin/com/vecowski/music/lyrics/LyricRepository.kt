package com.vecowski.music.lyrics

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

interface LyricRepository : ElasticsearchRepository<Lyric, String> {

    fun findByName(name: String): List<Lyric>

}