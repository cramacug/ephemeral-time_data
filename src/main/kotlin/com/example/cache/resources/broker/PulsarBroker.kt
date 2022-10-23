package com.example.cache.resources.broker

import com.example.cache.resources.BrokerOperations
import org.springframework.stereotype.Repository

@Repository
class PulsarBroker : BrokerOperations<String> {

    override fun checkIfTopicHasBeenUpdated(topic: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun obtain(topic: String): String {
        TODO("Not yet implemented")
    }
}