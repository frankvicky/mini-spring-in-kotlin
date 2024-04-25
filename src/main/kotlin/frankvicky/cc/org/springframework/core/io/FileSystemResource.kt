package frankvicky.cc.org.springframework.core.io

import java.io.File
import java.io.InputStream
import java.nio.file.Files

class FileSystemResource(private val filePath: String) : Resource {
    override fun getInputStream(): InputStream =
        File(filePath)
            .toPath()
            .let { Files.newInputStream(it) }
}