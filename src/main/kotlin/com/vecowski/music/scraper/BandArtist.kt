package com.vecowski.music.scraper

data class Band (val name: String, val artists: List<Artist>)

data class Artist (val name: String, val bands: List<Band>)