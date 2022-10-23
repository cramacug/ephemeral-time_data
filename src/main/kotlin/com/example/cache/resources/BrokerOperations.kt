package com.example.cache.resources

interface BrokerOperations<V> {

    fun checkIfTopicHasBeenUpdated(topic: String): Boolean

    fun obtain(topic: String): V
}

