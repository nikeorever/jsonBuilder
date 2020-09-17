package cn.nikeo.jsonbuilder

import org.json.JSONArray

internal class JSONArrayDslImpl : JSONArrayDsl {
    val jsonArray = JSONArray()
    override fun double(value: Double) {
        jsonArray.put(value)
    }

    override fun float(value: Float) {
        jsonArray.put(value)
    }

    override fun int(value: Int) {
        jsonArray.put(value)
    }

    override fun long(value: Long) {
        jsonArray.put(value)
    }

    override fun any(value: Any) {
        jsonArray.put(value)
    }

    override fun string(value: String) {
        jsonArray.put(value)
    }

    override fun boolean(value: Boolean) {
        jsonArray.put(value)
    }

    override fun obj(content: JSONObjectDsl.() -> Unit) {
        val impl = JSONObjectDslImpl()
        impl.apply(content)
        jsonArray.put(impl.jsonObject)
    }

    override fun arr(content: JSONArrayDsl.() -> Unit) {
        val impl = JSONArrayDslImpl()
        impl.apply(content)
        jsonArray.put(impl.jsonArray)
    }

    override fun toString(): String = jsonArray.toString()
}
