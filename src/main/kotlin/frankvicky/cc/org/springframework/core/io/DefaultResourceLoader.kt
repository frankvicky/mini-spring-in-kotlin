package frankvicky.cc.org.springframework.core.io

import java.net.URL


class DefaultResourceLoader : ResourceLoader {
    companion object {
        private const val CLASSPATH_URL_PREFIX = "classpath:"
    }

    override fun getResource(location: String): Resource =
        if (location.startsWith(CLASSPATH_URL_PREFIX))
            ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length))
        else {
            kotlin.runCatching { UrlResource(URL(location)) }
                .getOrElse { FileSystemResource(location) }
        }
}