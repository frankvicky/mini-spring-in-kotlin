package org.springframework.test.ioc

import frankvicky.cc.frankvicky.cc.org.springframework.beans.PropertyValue
import frankvicky.cc.frankvicky.cc.org.springframework.beans.PropertyValues
import frankvicky.cc.org.springframework.beans.factory.config.BeanDefinition
import frankvicky.cc.org.springframework.beans.factory.config.BeanReference
import frankvicky.cc.org.springframework.beans.factory.support.DefaultListableBeanFactory
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.test.ioc.bean.Car
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

    @Test
    fun testPopulateBeanWithBean() {
        val beanFactory = DefaultListableBeanFactory()

        val propertyValuesForCar = PropertyValues().also {
            it.addPropertyValue(PropertyValue("brand", "Porsche"))
            beanFactory.registerBeanDefinition("car", BeanDefinition(Car::class, it))
        }

        val propertyValuesForPerson = PropertyValues().also {
            it.addPropertyValue(PropertyValue("name", "Derek"))
            it.addPropertyValue(PropertyValue("age", 18))
            it.addPropertyValue(PropertyValue("car", BeanReference("car")))
            beanFactory.registerBeanDefinition("person", BeanDefinition(Person::class, it))
        }

        val person = beanFactory.getBean("person") as Person
        println(person)
        assertThat(person.name).isEqualTo("Derek")
        assertThat(person.age).isEqualTo(18)
        val car = person.car
        assertThat(car).isNotNull
        assertThat(car?.brand).isEqualTo("Porsche")
    }
}