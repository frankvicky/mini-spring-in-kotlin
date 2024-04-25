package frankvicky.cc.org.springframework.core.io

import java.io.InputStream

interface Resource {
    fun getInputStream(): InputStream
}