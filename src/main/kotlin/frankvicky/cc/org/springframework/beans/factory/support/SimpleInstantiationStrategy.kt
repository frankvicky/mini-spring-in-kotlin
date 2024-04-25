package frankvicky.cc.org.springframework.beans.factory.support

import frankvicky.cc.org.springframework.beans.BeansException
import frankvicky.cc.org.springframework.beans.factory.config.BeanDefinition
import kotlin.reflect.full.createInstance
import kotlin.reflect.jvm.jvmName


class SimpleInstantiationStrategy : InstantiationStrategy {
    // 簡單的 bean 實例化策略，使用 bean 的空建構子實例化
    override fun instantiate(beanDefinition: BeanDefinition): Any {
        val beanClass = beanDefinition.beanClass
        try {
            return beanClass.createInstance()
        } catch (e: Exception) {
            throw BeansException("Failed to instantiate [${beanClass.jvmName}", e)
        }
    }
}
