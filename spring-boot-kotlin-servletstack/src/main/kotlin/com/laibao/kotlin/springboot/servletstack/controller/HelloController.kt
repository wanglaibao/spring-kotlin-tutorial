package com.laibao.kotlin.springboot.servletstack.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping("/helloWorld")
    fun printHelloWorld():String {
        return "你好金戈先生,欢迎你来中国啊"
    }
}