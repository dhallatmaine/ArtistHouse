package com.vecowski.music

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.core.io.ClassPathResource
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.vecowski.music.scraper.BandsToMusiciansMap
import com.vecowski.music.scraper.MusiciansToBandsMap
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component


@SpringBootApplication(scanBasePackages = arrayOf("com.vecowski.music"))
class ArtistHouseApplication: SpringBootServletInitializer() {

    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(ArtistHouseApplication::class.java)
    }

}

@Component
class ContextRefreshedListener(private val musiciansToBandsMap: MusiciansToBandsMap,
                               private val bandsToMusiciansMap: BandsToMusiciansMap) : ApplicationListener<ContextRefreshedEvent> {

    override fun onApplicationEvent(contextRefreshedEvent: ContextRefreshedEvent) {
        val json = ClassPathResource("artists.json").inputStream.bufferedReader().readText()
        val members: HashMap<String, HashSet<String>> = Gson().fromJson(json, object : TypeToken<HashMap<String, HashSet<String>>>() {}.type)
        musiciansToBandsMap.clear()
        musiciansToBandsMap.set(members)
        bandsToMusiciansMap.set(members)
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(ArtistHouseApplication::class.java, *args)
}