package com.laibao.kotlin.springboot.servletstack.controller

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers.Unconfined
import kotlinx.coroutines.async
import kotlinx.coroutines.reactor.mono
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.util.function.Tuples

@RestController
class ReactiveController {

    @GetMapping("/reactiveCoroutine")
    fun getMessages(): Mono<String> = CoroutineScope(Unconfined).mono {
        "我是金戈"
    }

    @GetMapping("/reactiveCoroutineList")
    fun getMessageList(): Mono<List<String>> = CoroutineScope(Unconfined).mono {

       val peoples:Deferred<List<String>> = async {
            listOf("金戈","阿拉丁","和氏璧","海贝","风清扬","华罗庚")
       }

       peoples.await()
    }

    @GetMapping("/reactive",produces = ["application/stream+json"])
    fun getMessagesReactive(): Flux<String> {

        val list:List<String> = listOf("aaaa","bbbbb","cccccccc")

        return Flux.fromIterable(list)

    }


    @GetMapping("/fibonacci",produces = ["application/stream+json"])
    fun getFibonacciSeries(): Flux<Long> {

        return Flux.generate({ Tuples.of(0L, 1L) },
                { state, sink ->
                    if (state.t1 < 0) {
                        sink.complete()
                    } else {
                        sink.next(state.t1)
                    }
                    Tuples.of(state.t2, state.t1 + state.t2)
                })
    }

    @GetMapping("/fibonacci1",produces = ["text/event-stream"])
    fun getFibonacciSeries1(): Flux<Long> {

        return Flux.generate({ Tuples.of(0L, 1L) },
                { state, sink ->
                    if (state.t1 < 0) {
                        sink.complete()
                    } else {
                        sink.next(state.t1)
                    }
                    Tuples.of(state.t2, state.t1 + state.t2)
                })
    }


    @GetMapping("/hello")
    fun handle(): String {
        return "Hello WebFlux"
    }

    //以流的形式输出
    @GetMapping("/helloStream", produces = ["text/event-stream"])
    fun handler(): Flux<String> {
        return Flux.just("Hello world!", "This is from webflux")
    }

    //以流的形式输出
    @GetMapping("/helloStream1", produces = ["application/stream+json"])
    fun handler1(): Flux<String> {
        return Flux.just("Hello world!", "This is from webflux")
    }

}