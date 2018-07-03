package com.vecowski.music.scraper

import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
class BandsToMusiciansMap {

    private val bands = HashMap<String, HashSet<String>>()

    fun get(): HashMap<String, HashSet<String>> {
        return bands
    }

    fun set(members: HashMap<String, HashSet<String>>) {
        members.forEach{ (key, value) ->
             value.forEach {
                 add(it.toLowerCase(), key.toLowerCase())
             }
        }
    }

    private fun add(name: String, artistName: String) {
        if (bands[name] == null) {
            bands[name] = hashSetOf(artistName)
        } else {
            bands[name]!!.add(artistName)
        }
    }

}