package com.laibao.kotlin.springboot.kotlin.blog

import com.laibao.kotlin.springboot.blog.KotlinSpringBootBlogApplication
import com.laibao.kotlin.springboot.blog.entity.Article
import com.laibao.kotlin.springboot.blog.entity.User
import com.laibao.kotlin.springboot.blog.repository.ArticleRepository
import com.laibao.kotlin.springboot.blog.repository.UserRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull


@SpringBootTest(classes = [KotlinSpringBootBlogApplication::class])
class RepositoriesTest{

    @Autowired
    lateinit var  entityManager: TestEntityManager

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var articleRepository: ArticleRepository

    @Test
    fun `When findByIdOrNull then return Article`() {
        val juergen = User("springjuergen", "Juergen", "Hoeller")
        entityManager.persist(juergen)
        val article = Article("Spring Framework 5.0 goes GA", "Dear Spring community ...", "Lorem ipsum", juergen)
        entityManager.persist(article)
        entityManager.flush()
        val found = articleRepository.findByIdOrNull(article.id!!)
        assertThat(found).isEqualTo(article)
    }

    @Test
    fun `When findByLogin then return User`() {
        val juergen = User("springjuergen", "Juergen", "Hoeller")
        entityManager.persist(juergen)
        entityManager.flush()
        val user = userRepository.findByLogin(juergen.login)
        assertThat(user).isEqualTo(juergen)
    }


}