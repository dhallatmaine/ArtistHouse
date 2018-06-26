package com.vecowski.music.lyrics

import org.springframework.data.elasticsearch.annotations.Document

@Document(indexName = "lyrics_idx", type = "music")
data class Lyric (val id: String, val name: String, val artist: String)