package com.laibao.kotlin.springboot.servletstack.entity

import com.laibao.kotlin.springboot.servletstack.extensions.toSlug
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Article(
        var title: String,
        var headline: String,
        var content: String,
        @ManyToOne var author: User,
        var slug: String = title.toSlug(),
        var addedAt: LocalDateTime = LocalDateTime.now(),
        @Id @GeneratedValue var id: Long? = null){

        constructor():this("","","", User(),"")
}


@Entity
class User(
        var login: String="",
        var firstname: String="",
        var lastname: String="",
        var description: String? = null,
        @Id @GeneratedValue var id: Long? = null)

@Entity
data class Customer(
        val firstName: String = "",
        val lastName: String = "",
        @Id @GeneratedValue
        val id: Long = -1)


