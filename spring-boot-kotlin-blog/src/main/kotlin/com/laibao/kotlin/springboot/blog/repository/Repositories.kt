package com.laibao.kotlin.springboot.blog.repository

import com.laibao.kotlin.springboot.blog.entity.Article
import com.laibao.kotlin.springboot.blog.entity.User
import org.springframework.data.repository.CrudRepository

interface ArticleRepository : CrudRepository<Article, Long> {

    fun findBySlug(slug: String): Article?

    fun findAllByOrderByAddedAtDesc(): Iterable<Article>
}

interface UserRepository : CrudRepository<User, Long> {
    fun findByLogin(login: String): User
}