package frankvicky.cc.org.springframework.beans.factory.support

import frankvicky.cc.org.springframework.beans.factory.config.BeanDefinition

interface BeanDefinitionRegistry {
    fun registerBeanDefinition(beanName: String, beanDefinition: BeanDefinition)
}