package frankvicky.cc.org.springframework.beans.factory

// Spring 的基礎設施
// 提供了獲取 Bean 行為的抽象 (get by name, bet by type...)
interface BeanFactory {
    fun getBean(name: String): Any?
}