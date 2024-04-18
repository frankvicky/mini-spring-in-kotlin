package frankvicky.cc.org.springframework.beans.factory.config

// 單例註冊表介面
// 定義了單例註冊表的基本行為抽象
interface SingletonBeanRegistry {
    fun getSingleton(beanName: String): Any?
}