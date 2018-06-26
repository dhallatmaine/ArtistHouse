package com.vecowski.music.scraper

class MusciansAndBands {

    private val members = HashMap<String, HashSet<String>>()

    fun add(name: String, band: String) {
        if (members.get(name) == null) {
            members.put(name, hashSetOf(band))
        } else {
            val bands = members.get(name)
            bands!!.add(band)
        }
    }

    fun clear() {
        members.clear()
    }

    fun size(): Int {
        return members.size
    }

}