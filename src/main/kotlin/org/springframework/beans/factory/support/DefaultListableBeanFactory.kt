package frankvicky.cc.org.springframework.beans.factory.support

import frankvicky.cc.org.springframework.beans.BeansException
import frankvicky.cc.org.springframework.beans.factory.config.BeanDefinition

class DefaultListableBeanFactory: AbstractAutowireCapableBeanFactory(), BeanDefinitionRegistry {
    private val beanDefinitionMap = HashMap<String, BeanDefinition>()

    override fun getBeanDefinition(beanName: String): BeanDefinition =
        beanDefinitionMap[beanName] ?: throw BeansException("No bean named $beanName is defined")

    override fun registerBeanDefinition(beanName: String, beanDefinition: BeanDefinition) {
        beanDefinitionMap[beanName] = beanDefinition
    }
}