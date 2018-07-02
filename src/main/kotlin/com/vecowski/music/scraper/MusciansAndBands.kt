package com.vecowski.music.scraper

import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
class MusciansAndBands {

    private val members = ConcurrentHashMap<String, HashSet<String>>()

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

    fun get(): ConcurrentHashMap<String, HashSet<String>> {
        return members;
    }

}