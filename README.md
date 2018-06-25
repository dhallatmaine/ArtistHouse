# Lyrics site

powered by Springboot 2, Java 10, Kotlin, and ElasticSearch

`docker run -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" -e "node.name=data-node-1" -e "cluster.name=lyrics-cluster" docker.elastic.co/elasticsearch/elasticsearch:6.3.0`