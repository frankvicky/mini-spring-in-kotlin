package frankvicky.cc.org.springframework.core.io

import java.io.IOException
import java.io.InputStream
import java.net.URL

class UrlResource(private val url: URL) : Resource {
    override fun getInputStream(): InputStream =
        try {
            url.openConnection()
                .getInputStream()
        } catch (e: IOException) {
            throw e
        }
}