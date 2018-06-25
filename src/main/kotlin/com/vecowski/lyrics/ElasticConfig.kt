package com.vecowski.lyrics

import org.elasticsearch.client.transport.TransportClient
import org.elasticsearch.common.settings.Settings
import org.elasticsearch.common.transport.InetSocketTransportAddress
import org.elasticsearch.transport.client.PreBuiltTransportClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.core.ElasticsearchOperations
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate
import java.net.InetAddress

@Configuration
class ElasticConfig {

    @Value("\${elasticsearch.clustername}")
    val clusterName: String? = null

    @Value("\${elasticsearch.host}")
    val host: String? = null

    @Value("\${elasticsearch.port}")
    val port: String? = null

    @Bean
    fun client(): TransportClient {
        val settings = Settings.builder()
                .put("cluster.name", clusterName)
                .build()
        return PreBuiltTransportClient(settings).addTransportAddress(InetSocketTransportAddress(InetAddress.getByName(host), Integer.parseInt(port)))
    }
    @Bean
    fun elasticsearchTemplate(): ElasticsearchOperations {
        return ElasticsearchTemplate(client())
    }
}
