package com.example.cache.resources

interface CacheOperations<K, V> {
    fun getBy(key: K): V?

    fun upsert(key: K, value: V): V

    fun clear(key: K)
}

abstract class CacheStrategy<K, V> : CacheOperations<K, V> {

    override fun getBy(key: K): V? {
        val valueFromCache = getFromCache(key)
        return if (valueFromCache == null) {
            val obtainFromSource = obtainFromSource(key)
            updateCache(key, obtainFromSource)
            getBy(key)
        } else {
            valueFromCache
        }
    }

    override fun upsert(key: K, value: V): V {
        TODO("Not yet implemented")
    }

    override fun clear(key: K) {
        TODO("Not yet implemented")
    }

    abstract fun getFromCache(key: K): V
    abstract fun obtainFromSource(key: K): V
    abstract fun updateCache(key: K, value: V)

}