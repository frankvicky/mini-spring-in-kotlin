package frankvicky.cc.org.springframework.beans.factory.support

import cn.hutool.core.bean.BeanUtil
import frankvicky.cc.org.springframework.beans.BeansException
import frankvicky.cc.org.springframework.beans.factory.config.BeanDefinition
import frankvicky.cc.org.springframework.beans.factory.config.BeanReference
import kotlin.reflect.full.safeCast


// Spring 的核心類別（實作做了依賴注入功能）
// 擴充了AbstractBeanFactory並提供了一個框架方法（framework method）來對Bean進行自動注入
// 實例化Bean、執行依賴注入、初始化bean等相關工作都由該類別負責
abstract class AbstractAutowireCapableBeanFactory: AbstractBeanFactory() {

    var instantiationStrategy = SimpleInstantiationStrategy()

    override fun createBean(beanName: String, beanDefinition: BeanDefinition): Any =
        doCreateBean(beanName, beanDefinition)

    protected fun doCreateBean(beanName: String, beanDefinition: BeanDefinition): Any {
        val bean = try {
             createBeanInstance(beanDefinition)
                 .also { applyPropertyValues(beanName, it, beanDefinition) }
        } catch (e: Exception) {
            throw BeansException("Instantiation of bean failed", e)
        }

        return bean.also { addSingleton(beanName, it) }
    }

    // 實例化 bean
    protected fun createBeanInstance(beanDefinition: BeanDefinition): Any =
        instantiationStrategy.instantiate(beanDefinition)

    // 為 bean 填充屬性
    protected fun applyPropertyValues(beanName: String, bean: Any, beanDefinition: BeanDefinition) {
        try {
            for (propertyValue in beanDefinition.propertyValues.getPropertyValues()) {
                val name = propertyValue.name
                val value = BeanReference::class.safeCast(propertyValue.value)
                    ?.let { getBean(it.beanName) }
                    ?: propertyValue.value
                BeanUtil.setFieldValue(bean, name, value)
            }
        } catch (e: Exception) {
            throw BeansException("Error setting property values for bean: $beanName", e)
        }
    }
}