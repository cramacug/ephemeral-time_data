package com.example.cache.port.usecases

import com.example.cache.port.ConsumerCache

abstract class ConsumerBrokerCacheStrategy<T, K, V>(private val topic: T) : ConsumerCache<K, V> {

    @Override
    override fun get(key: K): V? {
        return if (checkIfTheEntityHasBeenUpdated(topic)) {
            val value = obtainFromDatasource(key, topic)
            upsertCache(key, value)
            this.get(key)
        } else {
            getBy(key)
        }
    }


    abstract fun getBy(key: K): V?
    abstract fun checkIfTheEntityHasBeenUpdated(topic: T): Boolean
    abstract fun obtainFromDatasource(key: K, topic: T): V
    abstract fun upsertCache(key: K, value: V)
}
