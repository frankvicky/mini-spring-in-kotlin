package frankvicky.cc.org.springframework.core.io

import java.io.FileNotFoundException
import java.io.InputStream

class ClassPathResource(private val path: String) : Resource {
    override fun getInputStream(): InputStream =
        this.javaClass.classLoader.getResourceAsStream(path)
           ?: throw FileNotFoundException("$path can be opened because it does not exist")
}