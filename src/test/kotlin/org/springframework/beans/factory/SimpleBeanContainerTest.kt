package org.springframework.beans.factory

import frankvicky.cc.org.springframework.beans.factory.BeanFactory
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SimpleBeanContainerTest {

    @Test
    fun testGetBean() {
        val beanFactory = BeanFactory()
        beanFactory.registerBean("helloService", HelloService())
        val helloService = beanFactory.getBean("helloService") as HelloService
        assertThat(helloService).isNotNull()
        assertThat(helloService.sayHello()).isEqualTo("hello")
    }
}

class HelloService {
    fun sayHello(): String {
        println("hello")
        return "hello"
    }
}