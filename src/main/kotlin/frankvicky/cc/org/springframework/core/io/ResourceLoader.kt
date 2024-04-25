package frankvicky.cc.org.springframework.core.io

interface ResourceLoader {
    fun getResource(location: String): Resource
}