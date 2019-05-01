package com.laibao.kotlin.springboot.servletstack

import com.laibao.kotlin.springboot.servletstack.configuration.BlogProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(BlogProperties::class)
class KotlinSpringBootServletStackApplication {

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<KotlinSpringBootServletStackApplication>(*args)
        }
    }
}