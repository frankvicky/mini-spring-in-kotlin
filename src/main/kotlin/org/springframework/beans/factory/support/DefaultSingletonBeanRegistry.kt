package frankvicky.cc.org.springframework.beans.factory.support

import frankvicky.cc.org.springframework.beans.factory.config.SingletonBeanRegistry

// 單例註冊表的基本實作
// 也是實際管理 Spring IoC 容器中的 Singleton Bean 的類別
open class DefaultSingletonBeanRegistry : SingletonBeanRegistry {
    private val singletonObjects = HashMap<String, Any>()

    override fun getSingleton(beanName: String): Any? = singletonObjects[beanName]

    protected fun addSingleton(beanName: String, singletonObject: Any) {
        singletonObjects[beanName] = singletonObject
    }
}