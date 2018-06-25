package com.vecowski.lyrics

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication(scanBasePackages = arrayOf("com.vecowski.lyrics"))
class LyricsApplication: SpringBootServletInitializer() {

    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(LyricsApplication::class.java)
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(LyricsApplication::class.java, *args)
}