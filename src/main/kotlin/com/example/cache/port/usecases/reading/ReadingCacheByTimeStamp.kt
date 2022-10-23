package com.example.cache.port.usecases.reading

import com.example.cache.port.usecases.ConsumerBrokerCacheStrategy
import com.example.cache.resources.BrokerOperations
import com.example.cache.resources.CacheOperations
import java.time.LocalDateTime

class ReadingCacheByTimeStamp(
    private val cache: CacheOperations<LocalDateTime, Double>,
    private val brokerOperations: BrokerOperations<Double>
) :
    ConsumerBrokerCacheStrategy<String, LocalDateTime, Double>("reading") {

    override fun getBy(key: LocalDateTime): Double? = cache.getBy(key)

    override fun checkIfTheEntityHasBeenUpdated(topic: String): Boolean = brokerOperations.checkIfTopicHasBeenUpdated(topic)

    override fun obtainFromDatasource(key: LocalDateTime, topic: String): Double = brokerOperations.obtain(topic)

    override fun upsertCache(key: LocalDateTime, value: Double) {
        cache.upsert(key, value)
    }

}