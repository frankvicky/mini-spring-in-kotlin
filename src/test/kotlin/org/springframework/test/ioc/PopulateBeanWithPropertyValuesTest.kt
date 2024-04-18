package org.springframework.test.ioc

import frankvicky.cc.frankvicky.cc.org.springframework.beans.PropertyValue
import frankvicky.cc.frankvicky.cc.org.springframework.beans.PropertyValues
import frankvicky.cc.org.springframework.beans.factory.config.BeanDefinition
import frankvicky.cc.org.springframework.beans.factory.support.DefaultListableBeanFactory
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.test.ioc.bean.Person

class PopulateBeanWithPropertyValuesTest {
    @Test
    fun testPopulateBeanWithPropertyValues() {
        val beanFactory = DefaultListableBeanFactory()
        val propertyValues = PropertyValues().apply {
            addPropertyValue(PropertyValue("name", "derek"))
            addPropertyValue(PropertyValue("age", 18))
        }

        beanFactory.registerBeanDefinition("person", BeanDefinition(Person::class, propertyValues))
        val person = beanFactory.getBean("person") as Person
        println(person)
        assertThat(person.name).isEqualTo("derek")
        assertThat(person.age).isEqualTo(18)
    }
}