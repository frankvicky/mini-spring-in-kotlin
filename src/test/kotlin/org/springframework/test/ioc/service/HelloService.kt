package org.springframework.test.ioc.service


class HelloService {
    fun sayHello(): String {
        println("hello")
        return "hello"
    }
}