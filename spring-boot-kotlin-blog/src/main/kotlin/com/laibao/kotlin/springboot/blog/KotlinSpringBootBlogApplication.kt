package com.laibao.kotlin.springboot.blog

import com.laibao.kotlin.springboot.blog.configuration.BlogProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(BlogProperties::class)
class KotlinSpringBootBlogApplication {

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<KotlinSpringBootBlogApplication>(*args)
        }
    }
}