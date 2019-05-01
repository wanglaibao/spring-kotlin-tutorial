package com.laibao.kotlin.springboot.servletstack.controller

import com.laibao.kotlin.springboot.servletstack.configuration.BlogProperties
import com.laibao.kotlin.springboot.servletstack.entity.Article
import com.laibao.kotlin.springboot.servletstack.entity.User
import com.laibao.kotlin.springboot.servletstack.extensions.format
import com.laibao.kotlin.springboot.servletstack.repository.ArticleRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class HtmlController (private val repository: ArticleRepository,
                      private val properties: BlogProperties){

    @GetMapping("/")
    fun blog(model: Model): String {
        model["title"] = properties.title
        model["banner"] = properties.banner
        model["articles"] = repository.findAllByOrderByAddedAtDesc().map { it.render() }
        return "blog"
    }

    @GetMapping("/article/{slug}")
    fun article(@PathVariable slug: String, model: Model): String {
        val article = repository
                .findBySlug(slug)
                ?.render()
                ?: throw IllegalArgumentException("Wrong article slug provided")
        model["title"] = article.title
        model["article"] = article
        return "article"
    }

    fun Article.render() = RenderedArticle(
            slug,
            title,
            headline,
            content,
            author,
            addedAt.format()
    )

    data class RenderedArticle(
            val slug: String,
            val title: String,
            val headline: String,
            val content: String,
            val author: User,
            val addedAt: String)
}