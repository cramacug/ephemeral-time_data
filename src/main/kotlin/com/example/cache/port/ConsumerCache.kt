package com.example.cache.port

interface ConsumerCache<K, V> {
    fun get(key: K): V?
}