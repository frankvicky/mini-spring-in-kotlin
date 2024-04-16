package org.springframework.test.ioc

import frankvicky.cc.org.springframework.beans.factory.config.BeanDefinition
import frankvicky.cc.org.springframework.beans.factory.support.DefaultListableBeanFactory
import org.junit.jupiter.api.Test

class BeanDefinitionAndBeanDefinitionRegistryTest {
    @Test
    fun testBeanFactory() {
        val beanFactory = DefaultListableBeanFactory()
        val beanDefinition = BeanDefinition(HelloService::class)
        beanFactory.registerBeanDefinition("helloService", beanDefinition)

        val helloService = beanFactory.getBean("helloService") as HelloService
        helloService.sayHello()
    }
}