package cn.nikeo.jsonbuilder

/**
 * Build JSON Array
 */
@Suppress("ClassName")
class arr(internal val content: JSONArrayDsl.() -> Unit) {

    override fun toString(): String {
        return JSONArrayDslImpl().apply(content).toString()
    }
}

/**
 * Build JSON Object
 */
@Suppress("ClassName")
class obj(internal val content: JSONObjectDsl.() -> Unit) {

    override fun toString(): String {
        return JSONObjectDslImpl().apply(content).toString()
    }
}

@DslMarker
private annotation class JsonBuilderDsl

@JsonBuilderDsl
interface JSONArrayDsl {
    fun double(value: Double)
    fun float(value: Float)
    fun int(value: Int)
    fun long(value: Long)
    fun any(value: Any)
    fun string(value: String)
    fun boolean(value: Boolean)
    fun obj(content: JSONObjectDsl.() -> Unit)
    fun arr(content: JSONArrayDsl.() -> Unit)
}

@JsonBuilderDsl
interface JSONObjectDsl {
    infix fun String.to(value: Double)
    infix fun String.to(value: Float)
    infix fun String.to(value: Int)
    infix fun String.to(value: Long)
    infix fun String.to(value: Any)
    infix fun String.to(value: String)
    infix fun String.to(value: Boolean)
    infix fun String.to(value: arr)
    infix fun String.to(value: obj)
}