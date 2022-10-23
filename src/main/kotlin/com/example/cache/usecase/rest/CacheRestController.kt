package com.example.cache.usecase.rest

import com.example.cache.port.ConsumerCache
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import javax.ws.rs.NotFoundException

@Controller("/cache")
class CacheRestController(@Qualifier("userCacheByString") val userCache: ConsumerCache<String, String>) {

    @GetMapping("/user?key={id}")
    fun getUserById(@PathVariable id: String): String = userCache.get(id) ?: throw NotFoundException()

}