package com.example.cache.port.usecases.user

import com.example.cache.port.usecases.ConsumerBrokerCacheStrategy
import com.example.cache.resources.BrokerOperations
import com.example.cache.resources.CacheOperations
import org.springframework.stereotype.Component

@Component
class UserCacheByString(val cache: CacheOperations<String, String>, val brokerOperations: BrokerOperations<String>) :
    ConsumerBrokerCacheStrategy<String, String, String>("user") {

    override fun getBy(key: String): String? = cache.getBy(key)
    override fun checkIfTheEntityHasBeenUpdated(topic: String): Boolean = brokerOperations.checkIfTopicHasBeenUpdated(topic)
    override fun obtainFromDatasource(key: String, topic: String): String = brokerOperations.obtain(topic)
    override fun upsertCache(key: String, value: String) { cache.upsert(key, value) }
}