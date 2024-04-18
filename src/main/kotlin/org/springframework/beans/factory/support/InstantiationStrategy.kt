package frankvicky.cc.org.springframework.beans.factory.support

import frankvicky.cc.org.springframework.beans.factory.config.BeanDefinition

interface InstantiationStrategy {
    fun instantiate(beanDefinition: BeanDefinition): Any?
}