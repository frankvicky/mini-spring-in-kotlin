package frankvicky.cc.org.springframework.beans.factory.support

import frankvicky.cc.org.springframework.beans.BeansException
import frankvicky.cc.org.springframework.beans.factory.config.BeanDefinition

// 相比於核心類別如 AbstractAutowireCapableBeanFactory
// DefaultListableBeanFactory 提供了更 high-level 的功能和實作
// 包括對於 BeanDefinition 的註冊和查詢
class DefaultListableBeanFactory: AbstractAutowireCapableBeanFactory(), BeanDefinitionRegistry {
    private val beanDefinitionMap = HashMap<String, BeanDefinition>()

    override fun getBeanDefinition(beanName: String): BeanDefinition =
        beanDefinitionMap[beanName] ?: throw BeansException("No bean named $beanName is defined")

    override fun registerBeanDefinition(beanName: String, beanDefinition: BeanDefinition) {
        beanDefinitionMap[beanName] = beanDefinition
    }
}