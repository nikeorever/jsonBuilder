package cn.nikeo.jsonbuilder

/**
 * Build JSON Object
 */
fun buildJSONObject(content: JSONObjectDsl.() -> Unit): String {
    return JSONObjectDslImpl().apply(content).toString()
}

/**
 * Build JSON Array
 */
fun buildJSONArray(content: JSONArrayDsl.() -> Unit): String {
    return JSONArrayDslImpl().apply(content).toString()
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
    infix fun String.to(value: Arr)
    infix fun String.to(value: Obj)
}

class Arr(val content: JSONArrayDsl.() -> Unit)
class Obj(val content: JSONObjectDsl.() -> Unit)
