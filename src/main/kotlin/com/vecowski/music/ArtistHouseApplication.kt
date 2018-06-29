package com.vecowski.music

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication(scanBasePackages = arrayOf("com.vecowski.music"))
class ArtistHouseApplication: SpringBootServletInitializer() {

    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(ArtistHouseApplication::class.java)
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(ArtistHouseApplication::class.java, *args)
}