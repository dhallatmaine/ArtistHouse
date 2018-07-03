package com.vecowski.music.scraper

import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
class MusiciansToBandsMap {

    private val members = HashMap<String, HashSet<String>>()

    fun add(name: String, band: String) {
        if (members[name] == null) {
            members[name] = hashSetOf(band)
        } else {
            members[name]!!.add(band)
        }
    }

    fun clear() {
        members.clear()
    }

    fun size(): Int {
        return members.size
    }

    fun get(): HashMap<String, HashSet<String>> {
        return members
    }

    fun set(members: HashMap<String, HashSet<String>>) {
        members.forEach{ (key, value) ->
            value.forEach {
                add(key.toLowerCase(), it.toLowerCase())
            }
        }
    }

}