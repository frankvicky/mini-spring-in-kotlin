package frankvicky.cc.org.springframework.beans.factory.config

import frankvicky.cc.frankvicky.cc.org.springframework.beans.PropertyValues
import kotlin.reflect.KClass

class BeanDefinition(var beanClass: KClass<*>, var propertyValues: PropertyValues = PropertyValues())
