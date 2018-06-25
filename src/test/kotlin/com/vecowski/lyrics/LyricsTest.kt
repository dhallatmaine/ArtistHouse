package com.vecowski.lyrics

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner


import org.junit.Assert.*
import org.springframework.data.elasticsearch.core.ElasticsearchOperations

@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(LyricsApplication::class))
class LyricsTest {

    @Autowired
    private val esOperations: ElasticsearchOperations? = null

    @Autowired
    private val lyricRepository: LyricRepository? = null

    @Before
    fun before() {
        esOperations!!.deleteIndex(Lyric::class.java)
        esOperations.createIndex(Lyric::class.java)
        esOperations.putMapping(Lyric::class.java)
        esOperations.refresh(Lyric::class.java)
    }

    @Test
    fun testSave() {

        val lyric = Lyric("1001", "Elasticsearch Basics", "Rambabu Posa")
        val testLyric = lyricRepository!!.save(lyric)

        assertNotNull(testLyric.id)
        assertEquals(testLyric.name, testLyric.name)
        assertEquals(testLyric.artist, testLyric.artist)

    }

}