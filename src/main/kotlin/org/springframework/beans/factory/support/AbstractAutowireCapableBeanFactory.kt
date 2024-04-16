package frankvicky.cc.org.springframework.beans.factory.support

import frankvicky.cc.org.springframework.beans.BeansException
import frankvicky.cc.org.springframework.beans.factory.config.BeanDefinition
import kotlin.reflect.full.createInstance


abstract class AbstractAutowireCapableBeanFactory: AbstractBeanFactory() {
    override fun createBean(beanName: String, beanDefinition: BeanDefinition): Any =
        doCreateBean(beanName, beanDefinition)

    protected fun doCreateBean(beanName: String, beanDefinition: BeanDefinition): Any {
        val beanClass = beanDefinition.beanClass

        val bean = try {
            beanClass.createInstance()
        } catch (e: Exception) {
            throw BeansException("Instantiation of bean failed", e)
        }

        addSingleton(beanName, bean)
        return bean
    }
}