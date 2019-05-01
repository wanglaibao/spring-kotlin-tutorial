package com.laibao.kotlin.springboot.kotlin.blog

import com.laibao.kotlin.springboot.blog.KotlinSpringBootBlogApplication
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [KotlinSpringBootBlogApplication::class])
class KotlinSpringBootBlogApplicationTest {

    @Test
    fun contextLoads() {
        println("测试服务启动了没有")
    }
}