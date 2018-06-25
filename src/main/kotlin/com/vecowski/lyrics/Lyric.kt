package com.vecowski.lyrics

import org.springframework.data.elasticsearch.annotations.Document

@Document(indexName = "lyrics_idx", type = "lyrics")
data class Lyric (val id: String, val name: String, val artist: String)