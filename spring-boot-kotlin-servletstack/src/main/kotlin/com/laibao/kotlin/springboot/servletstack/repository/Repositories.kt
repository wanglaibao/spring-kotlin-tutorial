package com.laibao.kotlin.springboot.servletstack.repository

import com.laibao.kotlin.springboot.servletstack.entity.Article
import com.laibao.kotlin.springboot.servletstack.entity.Customer
import com.laibao.kotlin.springboot.servletstack.entity.User
import org.springframework.data.repository.CrudRepository

interface ArticleRepository : CrudRepository<Article, Long> {

    fun findBySlug(slug: String): Article?

    fun findAllByOrderByAddedAtDesc(): Iterable<Article>
}

interface UserRepository : CrudRepository<User, Long> {
    fun findByLogin(login: String): User
}

interface CustomerRepository : CrudRepository<Customer, Long> {

    fun findByLastName(lastName: String): Iterable<Customer>
}