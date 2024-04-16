package frankvicky.cc.org.springframework.beans.factory.config

interface SingletonBeanRegistry {
    fun getSingleton(beanName: String): Any?
}