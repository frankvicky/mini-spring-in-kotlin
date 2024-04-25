package frankvicky.cc.org.springframework.beans.factory.support

import frankvicky.cc.org.springframework.beans.factory.config.BeanDefinition
import net.sf.cglib.proxy.Enhancer
import net.sf.cglib.proxy.MethodInterceptor


class CglibSubclassingInstantiationStrategy : InstantiationStrategy {
    // 使用 cglib 動態建構子類別
    override fun instantiate(beanDefinition: BeanDefinition): Any? {
        return Enhancer().apply {
            setSuperclass(beanDefinition.beanClass::class.java)
            setCallback(MethodInterceptor { obj, method, argsTemp, proxy -> proxy.invokeSuper(obj, argsTemp) })
        }.create()
    }
}
