package frankvicky.cc.org.springframework.beans.factory

interface BeanFactory {
    fun getBean(name: String): Any?
}