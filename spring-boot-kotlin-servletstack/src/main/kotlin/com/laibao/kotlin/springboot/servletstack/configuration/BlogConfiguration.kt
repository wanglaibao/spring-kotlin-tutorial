package com.laibao.kotlin.springboot.servletstack.configuration

import com.laibao.kotlin.springboot.servletstack.entity.Article
import com.laibao.kotlin.springboot.servletstack.entity.Customer
import com.laibao.kotlin.springboot.servletstack.entity.User
import com.laibao.kotlin.springboot.servletstack.repository.ArticleRepository
import com.laibao.kotlin.springboot.servletstack.repository.CustomerRepository
import com.laibao.kotlin.springboot.servletstack.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {
    val log = LoggerFactory.getLogger(BlogConfiguration::class.java)

    @Bean
    fun databaseInitializer(userRepository: UserRepository,
                            articleRepository: ArticleRepository,
                            customerRepository: CustomerRepository) = ApplicationRunner {

        val smaldini = userRepository.save(User("smaldini", "Stéphane", "Maldini"))

        articleRepository.save(Article(
                title = "Reactor Bismuth is out",
                headline = "Lorem ipsum",
                content = "dolor sit amet",
                author = smaldini
        ))

        articleRepository.save(Article(
                title = "Reactor Aluminium has landed",
                headline = "Lorem ipsum",
                content = "dolor sit amet",
                author = smaldini
        ))



        // save a couple of customers
        customerRepository.save(Customer("Jack", "Bauer"))
        customerRepository.save(Customer("Chloe", "O'Brian"))
        customerRepository.save(Customer("Kim", "Bauer"))
        customerRepository.save(Customer("David", "Palmer"))
        customerRepository.save(Customer("Michelle", "Dessler"))

        // fetch all customers
        log.info("Customers found with findAll():")
        log.info("-------------------------------")
        customerRepository.findAll().forEach { log.info(it.toString()) }
        log.info("")

        // fetch an individual customer by ID
        val customer = customerRepository.findById(1L)
        customer.ifPresent {
            log.info("Customer found with findById(1L):")
            log.info("--------------------------------")
            log.info(it.toString())
            log.info("")
        }

        // fetch customers by last name
        log.info("Customer found with findByLastName('Bauer'):")
        log.info("--------------------------------------------")
        customerRepository.findByLastName("Bauer").forEach { log.info(it.toString()) }
        log.info("")
    }
}