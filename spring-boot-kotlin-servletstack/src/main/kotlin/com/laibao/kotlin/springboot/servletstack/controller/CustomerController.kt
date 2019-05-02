package com.laibao.kotlin.springboot.servletstack.controller

import com.laibao.kotlin.springboot.servletstack.entity.Customer
import com.laibao.kotlin.springboot.servletstack.repository.CustomerRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers.Unconfined
import kotlinx.coroutines.async
import kotlinx.coroutines.reactor.mono


@RestController
class CustomerController (val customerRepository: CustomerRepository){

    @GetMapping("/customers")
    fun findAll():Mono<List<Customer>> = CoroutineScope(Unconfined).mono{
        val customers:Deferred<List<Customer>> = async {
            customerRepository.findAll().toList()
        }
        customers.await()
    }

    @GetMapping("/customers/{lastName}")
    fun findByLastName(@PathVariable lastName:String):Mono<List<Customer>> = CoroutineScope(Unconfined).mono{

        val list = async {
            customerRepository.findByLastName(lastName).toList()
        }

        list.await()
    }
}