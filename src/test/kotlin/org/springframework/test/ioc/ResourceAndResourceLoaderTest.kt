package org.springframework.test.ioc

import cn.hutool.core.io.IoUtil
import frankvicky.cc.org.springframework.core.io.DefaultResourceLoader
import frankvicky.cc.org.springframework.core.io.FileSystemResource
import frankvicky.cc.org.springframework.core.io.UrlResource
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResourceAndResourceLoaderTest {
    @Test
    fun testResourceLoader() {
        val resourceLoader = DefaultResourceLoader()

        resourceLoader.getResource("classpath:hello.txt")
            .getInputStream()
            .let { IoUtil.readUtf8(it) }
            .also { println(it) }
            .run { assertThat(this).isEqualTo("hello world") }


         resourceLoader.getResource("src/test/resources/hello.txt")
            .also { assertThat(it is FileSystemResource).isTrue() }
            .getInputStream()
            .let { IoUtil.readUtf8(it) }
            .also { println(it) }
            .run { assertThat(this).isEqualTo("hello world") }

        resourceLoader.getResource("https://www.google.com.tw")
            .also { assertThat(it is UrlResource).isTrue() }
            .getInputStream()
            .let { IoUtil.readUtf8(it) }
            .let { println(it) }
    }
}