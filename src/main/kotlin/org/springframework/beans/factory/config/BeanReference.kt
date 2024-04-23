package frankvicky.cc.org.springframework.beans.factory.config

// 用於處理 Bean 對於其他 Bean 的引用，透過該類別可輕鬆實現 Compose
class BeanReference(val beanName: String)