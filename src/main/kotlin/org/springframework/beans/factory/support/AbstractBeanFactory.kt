package frankvicky.cc.org.springframework.beans.factory.support

import frankvicky.cc.org.springframework.beans.factory.BeanFactory
import frankvicky.cc.org.springframework.beans.factory.config.BeanDefinition

abstract class AbstractBeanFactory : DefaultSingletonBeanRegistry(), BeanFactory {
    override fun getBean(name: String): Any? = getSingleton(name) ?: createBean(name, getBeanDefinition(name))

    protected abstract fun createBean(beanName: String, beanDefinition: BeanDefinition): Any

    protected abstract fun getBeanDefinition(beanName: String): BeanDefinition
}