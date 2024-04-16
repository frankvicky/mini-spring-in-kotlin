package frankvicky.cc.org.springframework.beans.factory.support

import frankvicky.cc.org.springframework.beans.factory.config.SingletonBeanRegistry

open class DefaultSingletonBeanRegistry : SingletonBeanRegistry {
    private val singletonObjects = HashMap<String, Any>()

    override fun getSingleton(beanName: String): Any? = singletonObjects[beanName]

    protected fun addSingleton(beanName: String, singletonObject: Any) {
        singletonObjects[beanName] = singletonObject
    }
}