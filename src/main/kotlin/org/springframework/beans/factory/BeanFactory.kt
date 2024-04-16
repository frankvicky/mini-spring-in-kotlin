package frankvicky.cc.org.springframework.beans.factory

class BeanFactory {
    private val nameToBean: HashMap<String, Any> = HashMap()

    fun registerBean(name: String, bean: Any) {
        nameToBean[name] = bean
    }

    fun getBean(name: String): Any? = nameToBean[name]
}