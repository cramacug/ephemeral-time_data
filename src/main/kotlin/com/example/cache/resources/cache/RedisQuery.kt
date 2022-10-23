package com.example.cache.resources.cache

import com.example.cache.resources.QueryOperations
import org.springframework.stereotype.Repository

@Repository
class RedisQuery : QueryOperations<String, String> {

    val source: Map<String, String> = mapOf()
    val resource: MutableMap<String, String> = mutableMapOf()

    override fun getBy(key: String): String? = resource[key] ?: source[key]

    override fun upsert(key: String, value: String): String {
        resource[key] = value
        return resource[key]!!
    }

    override fun clear(key: String) {
        resource.remove(key)
    }
}