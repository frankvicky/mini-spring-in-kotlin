package frankvicky.cc.org.springframework.beans.factory.support

import cn.hutool.core.bean.BeanUtil
import frankvicky.cc.org.springframework.beans.BeansException
import frankvicky.cc.org.springframework.beans.factory.config.BeanDefinition
import kotlin.reflect.full.createInstance


// Spring 的核心類別（實作做了依賴注入功能）
// 擴充了AbstractBeanFactory並提供了一個框架方法（framework method）來對Bean進行自動注入
// 實例化Bean、執行依賴注入、初始化bean等相關工作都由該類別負責
abstract class AbstractAutowireCapableBeanFactory: AbstractBeanFactory() {

    var instantiationStrategy = SimpleInstantiationStrategy()

    override fun createBean(beanName: String, beanDefinition: BeanDefinition): Any =
        doCreateBean(beanName, beanDefinition)

    protected fun doCreateBean(beanName: String, beanDefinition: BeanDefinition): Any {
        val beanClass = beanDefinition.beanClass

        val bean = try {
             beanClass.createInstance()
                 .also { applyPropertyValues(beanName, it, beanDefinition) }
        } catch (e: Exception) {
            throw BeansException("Instantiation of bean failed", e)
        }

        addSingleton(beanName, bean)
        return bean
    }

    // 實例化 bean
    protected fun createBeanInstance(beanDefinition: BeanDefinition): Any =
        instantiationStrategy.instantiate(beanDefinition)

    // 為 bean 填充屬性
    protected fun applyPropertyValues(beanName: String, bean: Any, beanDefinition: BeanDefinition) {
        try {
            beanDefinition.propertyValues.getPropertyValues()
                .forEach { BeanUtil.setFieldValue(bean, it.name, it.value) }
        } catch (e: Exception) {
            throw BeansException("Error setting property values for bean: $beanName", e)
        }
    }
}