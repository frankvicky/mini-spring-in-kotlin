package frankvicky.cc.frankvicky.cc.org.springframework.beans

class PropertyValues {
    private val propertyValueList = arrayListOf<PropertyValue>()

    fun addPropertyValue(propertyValue: PropertyValue) {
        propertyValueList.add(propertyValue)
    }

    fun getPropertyValues(): Array<PropertyValue> = propertyValueList.toTypedArray()

    fun getPropertyValue(propertyName: String): PropertyValue? = propertyValueList.find { it.name == propertyName }
}
