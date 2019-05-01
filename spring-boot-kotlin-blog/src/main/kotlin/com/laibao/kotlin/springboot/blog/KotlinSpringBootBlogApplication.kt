package com.laibao.kotlin.springboot.blog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSpringBootBlogApplication {

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<KotlinSpringBootBlogApplication>(*args)
        }
    }
}